package tianxing.app.callcall.customer.api;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;


/**
 * Package_name:com.yunduo.huopinclientapp.api
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:23
 */
public class ClientApi {

    //获取验证码成功
    public static final int SEND_VERFIY_SUCCESS = 0x82;

    //注册  和登录成功或失败的回调
    public static final int REGISTER_SUCCESS = 0x22;
    public static final int LOGIN_SUCCESS = 0x81;
    public static final int LOGIN_OR_REGISTER_ERROR = 0x12;

    /**
     * 发送验证码
     * @param registerActivity
     * @param acc
     * @param handler
     */
    public static void sendVerfiy(final Activity registerActivity, final String acc, final Handler handler) {
        OkGo.get(URLs.URL_SENDVERFIY)
                .tag(registerActivity)
                .params("sendMobile", acc)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //不做处理   用户自己处理
                        if(s!=null){
                            Message msg = new Message();
                            msg.obj = s;
                            msg.what = SEND_VERFIY_SUCCESS;
                            handler.sendMessage(msg);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        OkGo.getInstance().cancelTag(registerActivity);
                    }
                });
    }


    /**
     * 登录  或者注册
     * @param activity
     * @param acc
     * @param pwd
     * @param handler
     * @param action
     * @return
     */
    public static void toLogin(final Activity activity, String acc, String pwd, String verfiy, final Handler handler, final String action) {
        Log.i("info","开始登陆====");
        String url = null;
        HashMap map = getMap();
        if(action.equals("register")){
            url =URLs.URL_REGISTER;
            map.put("userAccount", acc);
            map.put("userPassword", pwd);
            map.put("registerCode", verfiy);
        }else{
            url =URLs.URL_LOGIN;
            map.put("userAccount", acc);
            map.put("userPassword", pwd);
        }
        OkGo.get(url)
                .tag(activity)
                .params(map,false)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, okhttp3.Call call, Response response) {
                        Log.i("info","注册成功---"+"登录");
                        if(s!=null){
                            if(action.equals("register")){//处理注册
                                Message msg = new Message();
                                msg.obj = s;
                                msg.what = REGISTER_SUCCESS;
                                handler.sendMessage(msg);
                            }else{
                                //处理登录
                                Message msg = new Message();
                                msg.obj = s;
                                msg.what = LOGIN_SUCCESS;
                                handler.sendMessage(msg);
                            }
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Log.i("info","失败====");
                        handler.sendEmptyMessage(LOGIN_OR_REGISTER_ERROR);
                    }
                });
    }


    static HashMap<String, Object> map = null;

    /**
     * 获取  map对象
     *
     * @return
     */
    public static HashMap<String, Object> getMap() {
        if (map == null) {
            map = new HashMap<String, Object>();
        }
        return map;
    }


}
