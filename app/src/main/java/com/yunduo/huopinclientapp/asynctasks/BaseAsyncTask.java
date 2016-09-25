package com.yunduo.huopinclientapp.asynctasks;

import android.os.AsyncTask;

/**
 * Package_name:com.yunduo.huopinclientapp.asynctasks
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:03
 */
public abstract class BaseAsyncTask extends AsyncTask<String,Void,TaskResult>{

    private TaskCallback callback;

    public BaseAsyncTask(TaskCallback callback){
        this.callback = callback;
    }


    //调用 回调到主线程
    @Override
    protected void onPostExecute(TaskResult taskResult) {
        if (callback != null) {
            callback.onTaskFinished(taskResult);
        }
    }

}
