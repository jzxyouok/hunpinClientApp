package com.yunduo.huopinclientapp;

import android.app.AppOpsManager;
import android.app.Application;
import android.appwidget.AppWidgetManager;

/**
 * Package_name:com.yunduo.huopinmerchantapp
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/13  16:58
 */
public final class AppAplication extends Application {

    public static  AppAplication instance;

    public AppAplication(){
        if(null == instance){
            instance = this;
        }
    }

    //内存  占用较高时    调用垃圾回收机制
    public void onLowMomory(){
        super.onLowMemory();
        System.gc();
    }
}
