package com.yunduo.huopinclientapp.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * PACKAGE_NAME:zhaoq.hl.fastdelivery.utils
 * CREATE_BY:zhaoqiang
 * AUTHOR_EMAIL:zhaoq_hero@163.com
 * DATE: 2016/03/26  10:06
 */
public final class MyToast {

    /**
     * 自定义toast  显示位置
     * @param context
     * @param message
     * @return
     */
    public static void ToastIncenter(Context context,String message){
        Toast toast = Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    /**
     * 自定义toast  显示位置
     * @param context
     * @param message
     * @return
     */
    public static void ToastInLow(Context context,String message){
        Toast toast = Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.show();
    }


}
