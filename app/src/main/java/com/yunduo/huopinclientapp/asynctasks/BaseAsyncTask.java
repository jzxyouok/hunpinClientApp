package com.yunduo.huopinclientapp.asynctasks;

import android.app.ActionBar;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/**
 * Package_name:com.yunduo.huopinclientapp.asynctasks
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:03
 */
public abstract class BaseAsyncTask extends AsyncTask<String,Void,TaskResult>{

    private TaskCallback callback;

    private Context context;

    public BaseAsyncTask(Context context,TaskCallback callback){
        this.callback = callback;
        this.context = context;
    }



    //调用 回调到主线程
    @Override
    protected void onPostExecute(TaskResult taskResult) {
        if (callback != null) {
            callback.onTaskFinished(taskResult);
        }
    }

}
