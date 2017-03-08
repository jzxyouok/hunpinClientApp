package tianxing.app.callcall.customer.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import tianxing.app.callcall.customer.client.ApiClient;
import tianxing.app.callcall.customer.domain.UserData;

/**
 * Package_name:com.yunduo.huopinclientapp.utils
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/22  13:14
 *
 * 登录管理类
 */
public final class LoginUtil {

    private LoginUtil(){
    }


    //判断  当前软件中   是否有用户登录
    public static boolean isLogin(Context context) {
        //获取 sp文件  内容   判断  当前是否有用户登录
        boolean isExit = (boolean) SPUtils.get_LOGIN(context,"isLogin",false);  //默认  没有登录
        return isExit;
    }

    //判断  当前是否有用户登录
    public static boolean saveUserLoginData(Context context, UserData userData) {
        return false;
    }

    public static void toLogin(Activity activity, String acc, String pwd,String verfiy, Handler handler, String action) {
        ApiClient.toLogin(activity,acc,pwd,verfiy,handler,action);
    }

    /**
     * 发送验证码
     * @param registerActivity
     * @param acc
     * @param handler
     */
    public static void sendVerfiy(Activity registerActivity, String acc, Handler handler) {
        ApiClient.sendVerfiy(registerActivity,acc,handler);
    }
}
