package com.yunduo.huopinclientapp.asynctasks;

import android.content.Context;

import com.yunduo.huopinclientapp.api.ClientApi;
import com.yunduo.huopinclientapp.configs.URLS;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Package_name:com.yunduo.huopinclientapp.asynctasks
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/10/12  16:37
 */
public class LoginAsyncTask extends BaseAsyncTask{

    private Context context;

    public LoginAsyncTask(Context context, TaskCallback callback) {
        super(context, callback);
        this.context = context;
    }

    @Override
    protected TaskResult doInBackground(String... params) {

        TaskResult ret = new TaskResult();

        ret.action = URLS.TASK_ACTION_REGISTER_TASK;

        if(params != null){

            String acc = params[0];
            String pwd = params[1];

            JSONArray object = ClientApi.getLoginResult(acc,pwd);

            if(object!=null){
                ret.data = object;
            }
        }
        return ret;
    }
}
