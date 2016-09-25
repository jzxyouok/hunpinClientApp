package com.yunduo.huopinclientapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.yunduo.huopinclientapp.activitys.LoginActivity;
import com.yunduo.huopinclientapp.configs.Configs;
import com.yunduo.huopinclientapp.domain.UserData;

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
        boolean isExit = (boolean) SPUtils.get(context,"isLogin",false);  //默认  没有登录

        Log.i("info",isExit+"----------");
        if(isExit){
            return true;
        }
        return false;
    }

    //判断  当前是否有用户登录
    public static boolean saveUserLoginData(Context context,UserData userData) {
        //获取 sp文件  内容   判断  当前是否有用户登录
        if(userData!=null){

            SPUtils.put(context, "isLogin",true);
            SPUtils.put(context, "userPhone",userData.getPhone());
            SPUtils.put(context, "userPhone",userData.getUserNick());
            SPUtils.put(context, "userCard",userData.getUserCard());
            SPUtils.put(context, "userCityLongItude",userData.getUserCity().getLongItude());
            SPUtils.put(context, "userCityLatitude",userData.getUserCity().getLatitude());

            return true;
        }
        return false;
    }

}
