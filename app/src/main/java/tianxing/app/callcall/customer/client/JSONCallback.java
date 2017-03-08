package tianxing.app.callcall.customer.client;

import android.util.Log;

import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.BaseRequest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;
import tianxing.app.callcall.customer.domain.DataBean;
import tianxing.app.callcall.customer.domain.FirstGridViewBean;
import tianxing.app.callcall.customer.domain.OKDataResponse;
import tianxing.app.callcall.customer.utils.GsonConvertUtils;

/**
 * Package_name:tianxing.app.callcall.customer.client
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/05  23:07
 */

public abstract class JSONCallback <T> extends AbsCallback<T> {

    /**
     * 数据 请求之前   可以在此处  添加请求的请求头  或者请求参数
     * token  或者  设备信息
     * @param request
     */
    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        // 还可以在这里对所有的参数进行加密，均在这里实现
        // request.headers("header1", "HeaderValue1")
        //           .params("params1", "ParamsValue1")
        //           .params("token", "3215sdf13ad1f65asd4f3ads1f");
    }

    @Override
    public T convertSuccess(Response response) throws Exception {
        //通过泛型解析实际的参数：
        Type genType = getClass().getGenericSuperclass();
        //从上述的类中取出真实的泛型参数，有些类可能有多个泛型，所以是数值
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        //获取第一个泛型
        Type type = params[0];

        if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");
        //如果确实还有泛型，那么我们需要取出真实的泛型，得到如下结果
        //class com.lzy.demo.model.LzyResponse
        //此时，rawType的类型实际上是 class，但 Class 实现了 Type 接口，所以我们用 Type 接收没有问题
        Type rawType = ((ParameterizedType) type).getRawType();

        //以下代码是根据泛型解析数据，返回对象，返回的对象自动以参数的形式传递到 onSuccess 中，可以直接使用
        JsonReader jsonReader = new JsonReader(response.body().charStream());
        if (rawType == Void.class) {
//            //无数据类型,表示没有data数据的情况（以  new DialogCallback<LzyResponse<Void>>(this)  以这种形式传递的泛型)
//            SimpleResponseEntity simpleResponse = GsonConvertUtils.fromJson(jsonReader, SimpleResponseEntity.class);
//            response.close();
//            //noinspection unchecked
//            return (T) simpleResponse.toDataResponse();
            Log.i("info","====");
        }
        if (rawType == OKDataResponse.class) {
            // 打印出的数据：
            //有数据类型，表示有data
            OKDataResponse lzyResponse = GsonConvertUtils.fromJson(jsonReader, type);
//            OKDataResponse<ArrayList<DataBean<ArrayList<FirstGridViewBean>>>> lzyResponse = GsonConvertUtils.fromJson(jsonReader, type);

            Log.i("info","rawType:"+rawType.toString());
            Log.i("info","type:"+type.toString());
            Log.i("info","jsonReader:"+jsonReader.toString());
            Log.i("info","lzyResponse:"+lzyResponse.toString());

            response.close();

            if(lzyResponse == null){
                Log.i("info", lzyResponse + "返回数据是null");
            }
//            int code = lzyResponse.status;
            //这里的  0是以下意思
            //一般来说服务器会和客户端约定一个数表示成功，其余的表示失败，这里根据实际情况修改
//            if (code == 200) {
            //两百  成功  其余  一律失败
            return (T) lzyResponse;
//            } else {
//                throw new IllegalStateException("错误代码：" + code + "，错误信息：" + lzyResponse.status);
//            }
        } else {
            response.close();
            throw new IllegalStateException("解析异常-----基类错误无法解析!");
        }
    }

    /**
     * 连接异常
     */
    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
    }
}
