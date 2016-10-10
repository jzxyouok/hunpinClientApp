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
            //保存  登录
            SPUtils.put(context, "isLogin",false);
            SPUtils.put(context, "userAccount",userData.getUserAccount());
            SPUtils.put(context, "userName",userData.getUserName());
            SPUtils.put(context, "userCard",userData.getUserCardId());

            SPUtils.put(context, "userCityLongItude",userData.getCity().getLongItude());
            SPUtils.put(context, "userCityLatitude",userData.getCity().getLatitude());
            return true;
        }
        return false;
    }

}
