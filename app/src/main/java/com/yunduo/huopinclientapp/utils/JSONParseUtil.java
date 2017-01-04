package com.yunduo.huopinclientapp.utils;

import android.util.Log;

import com.lzy.okgo.OkGo;
import com.yunduo.huopinclientapp.domain.UserData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Package_name:com.yunduo.huopinclientapp.utils
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/01/04  23:43
 */

public final class JSONParseUtil {


    /**
     * 解析  用户信息 bean
     * @param data
     */
    public static UserData getUseBean(String data) throws JSONException {

        JSONObject userJson = new JSONObject(data);
        UserData user = null;
        try {
            if(userJson instanceof JSONObject){
                //TODO
                user = new UserData();
                user.setCustomerAccount(userJson.getString("customerAccount"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
}
