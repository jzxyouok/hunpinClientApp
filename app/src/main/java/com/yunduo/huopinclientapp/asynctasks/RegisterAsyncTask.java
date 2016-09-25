package com.yunduo.huopinclientapp.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.SyncStateContract;

import com.yunduo.huopinclientapp.api.ClientApi;
import com.yunduo.huopinclientapp.configs.URLS;

import org.json.JSONObject;

/**
 * Package_name:com.yunduo.huopinclientapp.asynctasks
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:03
 * 请求注册信息的   异步任务类
 */
public class RegisterAsyncTask extends BaseAsyncTask {

    private  Context context;

    public RegisterAsyncTask(Context context, TaskCallback callback) {
        super(callback);
        this.context = context;
    }

    @Override
    protected TaskResult doInBackground(String... params) {

        TaskResult ret = new TaskResult();

        ret.action = URLS.TASK_ACTION_REGISTER_TASK;

        if(params != null){

            String acc = params[0];
            String pwd = params[1];

            JSONObject object = ClientApi.getRegisterResult(acc,pwd);

            if(object!=null){
                ret.data = object;
            }
        }
        return ret;
    }


}