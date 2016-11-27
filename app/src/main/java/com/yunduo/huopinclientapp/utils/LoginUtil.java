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
        boolean isExit = (boolean) SPUtils.get_LOGIN(context,"isLogin",false);  //默认  没有登录

        if(isExit){
            MyToast.ToastIncenter(context,"当前已经登录");
        }

        return isExit;
    }

    //判断  当前是否有用户登录
    public static boolean saveUserLoginData(Context context,UserData userData) {
        //获取 sp文件  内容   判断  当前是否有用户登录
        if(userData!=null){
            //保存  登录
            SPUtils.put_LOGIN(context, "isLogin",true);
            SPUtils.put_LOGIN(context, "userPassword",userData.getUserPassword());
            SPUtils.put_LOGIN(context, "userPhoto",userData.getUserPhoto());
            SPUtils.put_LOGIN(context, "userPayPassword",userData.getUserPayPassword());
            SPUtils.put_LOGIN(context, "userRealName",userData.getUserRealName());
            SPUtils.put_LOGIN(context, "userScore",userData.getUserScore());
            SPUtils.put_LOGIN(context, "userName",userData.getUserName());
            SPUtils.put_LOGIN(context, "userId",userData.getUserId());
            SPUtils.put_LOGIN(context, "userRegisterTime",userData.getUserRegisterTime());
            SPUtils.put_LOGIN(context, "userToken",userData.getUserToken());
            SPUtils.put_LOGIN(context, "userAccount",userData.getUserAccount());
            SPUtils.put_LOGIN(context, "userCardId",userData.getUserCardId());
            SPUtils.put_LOGIN(context, "userLevelId",userData.getUserLevelId());

            SPUtils.put_LOGIN(context, "userCityLongItude",userData.getCity().getLongItude());
            SPUtils.put_LOGIN(context, "userCityLatitude",userData.getCity().getLatitude());
            return true;
        }
        return false;
    }

}
