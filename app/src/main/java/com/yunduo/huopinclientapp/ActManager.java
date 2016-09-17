package com.yunduo.huopinclientapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Stack;

/**
 * Package_name:com.yunduo.huopinmerchantapp
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/12  22:55
 * activity的 堆栈式管理
 */
public final class ActManager {

    private static Stack<Activity> activityStack;
    private static ActManager instance;
    /**
     * 单一实例
     */
    public static ActManager getActManager() {
        if (instance == null) {
            instance = new ActManager();
        }

        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        return instance;
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 从栈中  移除指定的Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                finishActivity(activityStack.get(i));
            }
        }
        activityStack.clear();
    }

    /**
     * @param context
     * @param targetActivityClazz
     * @param bundle 传输数据用的bundle; null表示不需要传数据
     */
    public static void openActivity(Context context, Class<? extends Activity> targetActivityClazz, Bundle bundle){
        Intent intent = new Intent(context, targetActivityClazz);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }


    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
        }
    }

}
