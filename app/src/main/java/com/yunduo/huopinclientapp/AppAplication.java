package com.yunduo.huopinclientapp;

import android.app.AppOpsManager;
import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import cn.smssdk.SMSSDK;

/**
 * Package_name:com.yunduo.huopinmerchantapp
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/13  16:58
 */
public final class AppAplication extends Application {

    public static  AppAplication instance;
    private static Context context;
    public static RequestQueue requestQueue; //volley的请求队列

    public AppAplication(){
        if(null == instance){
            instance = this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initSMSSdk();
        context=this;
    }

    private static final String APPKey = "173f02ecf977c";
    private static final String APPScrate="77d726ad03a626abcf7c70e31612024c";

    //初始化  第三方sdk
    private void initSMSSdk() {
        //初始化  短信验证sdk
        SMSSDK.initSDK(getApplicationContext(), APPKey, APPScrate);
    }

    //获取  请求队列
    public static RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);//初始化Volley
        }
        return requestQueue;
    }

    //内存  占用较高时    调用垃圾回收机制
    public void onLowMomory(){
        super.onLowMemory();
        System.gc();
    }
}
