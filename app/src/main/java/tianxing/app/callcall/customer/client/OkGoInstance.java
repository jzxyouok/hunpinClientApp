package tianxing.app.callcall.customer.client;


import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.logging.Level;

import tianxing.app.callcall.customer.AppContext;

/**
 * Package_name:com.edu.fangqiu.gkww.utils
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/14  14:48
 *
 * 初始化  OKGO
 */
public final class OkGoInstance {

    private static int READ_OUTTIME = 5000;
    private static int WRITE_OUTTIME = 30000;
    private static int CONNECT_OUTTIME = 5000;

//    private static int CACAHE_OUTTIME = 300000;

    private static HttpHeaders headers;

    private static HttpParams params;

    private static OkGoInstance instance;

    private OkGoInstance(){
    }

    /**
     * 保证单实例   懒汉式   保证线程安全
     */
    public static synchronized OkGoInstance getInstance() {
        if (instance == null) {
                instance = new OkGoInstance();
        }
        return instance;
    }

    /**
     * 初始化  我们需要   使用的  网络框架   okGo
     */
    public static void init(AppContext appContext) {
        //初始化
        OkGo.init(appContext);

        //初始化 header  方便以后调用   header不支持中文，不允许有特殊字符
        headers = new HttpHeaders();
        headers.put("User-Agent", UserAgent.getUserAgent(appContext));

        //初始化  参数   支持中文   这里可以传入  全局参数
        params = new HttpParams();
//        params.put("commomParams1","commonParamValues1");
//        params.put("commomParams2","commonParamValues2");

        OkGoInstance.appendRequest();
    }

    /**
     * 以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,
     * 那么对于该请求来讲,请求中的参数会覆盖全局参数
     * 好处是全局参数统一,特定请求可以特别定制参数
     */
    private static void appendRequest() {
        OkGo.getInstance()
                // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                .debug("OkGo", Level.INFO, true)
                //如果使用默认的 60秒,以下三行也不需要传
                .setConnectTimeout(READ_OUTTIME)  //全局的连接超时时间
                .setReadTimeOut(WRITE_OUTTIME)     //全局的读取超时时间
                .setWriteTimeOut(CONNECT_OUTTIME)    //全局的写入超时时间
                //全局统一设置缓存模式   首先使用缓存    然后再请求
//                .setCacheMode(CacheMode.IF_NONE_CACHE_REQUEST)
                .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                //设置缓存过期时间   永不过期  除非  用户清除缓存
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setRetryCount(2)
                //如果不想让框架管理cookie（或者叫session的保持）,以下不需要
                //.setCookieStore(new MemoryCookieStore())            //cookie使用内存缓存（app退出后，cookie消失）
                //.setCookieStore(new PersistentCookieStore())        //cookie持久化存储，如果cookie不过期，则一直有效
                //方法一：信任所有证书
                .setCertificates()

                //这两行同上，不需要就不要加入
                .addCommonHeaders(headers)  //设置全局公共头
                .addCommonParams(params);   //设置全局公共参数
    }

}
