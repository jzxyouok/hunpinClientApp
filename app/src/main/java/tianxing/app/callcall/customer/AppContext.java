package tianxing.app.callcall.customer;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import tianxing.app.callcall.customer.client.OkGoInstance;
import tianxing.app.callcall.customer.utils.ImagePickerUtils;
import tianxing.app.callcall.customer.utils.SharePreferanceUtil;
import tianxing.app.callcall.customer.utils.StringUtils;

import java.util.UUID;

/**
 * Package_name:com.yunduo.huopinmerchantapp
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/13  16:58
 */
public final class AppContext extends Application {

    public static AppContext instance;
    private static Context context;

    private static final String CONFIG_UNIQUEID = "unique_id";

    public AppContext(){
        if(null == instance){
            instance = this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化   ImagePicker选择
        context=this;
        //初始化   网络连接  工具类
        OkGoInstance.getInstance().init(this);
        ImagePickerUtils.getImpickerUtils().initImagePicker(this);
    }

    //内存  占用较高时    调用垃圾回收机制
    public void onLowMomory(){
        super.onLowMemory();
        System.gc();
    }

    /**
     * 获取App安装包信息
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if(info == null) info = new PackageInfo();
        return info;
    }

    /**
     * 获取 App的唯一  标识
     * @return
     */
    public String getAppId() {
        String uniqueId = (String) SharePreferanceUtil.getSpUtil().get_sp(this,CONFIG_UNIQUEID,"");
        if(StringUtils.isEmpty(uniqueId)){
            uniqueId = UUID.randomUUID().toString();
            SharePreferanceUtil.getSpUtil().put_sp(this,CONFIG_UNIQUEID,uniqueId);
        }
        return uniqueId;
    }
}
