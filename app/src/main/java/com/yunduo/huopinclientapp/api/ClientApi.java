package com.yunduo.huopinclientapp.api;

import android.util.Log;

import com.yunduo.huopinclientapp.AppException;
import com.yunduo.huopinclientapp.configs.URLS;
import com.yunduo.huopinclientapp.utils.HttpTools;
import com.yunduo.huopinclientapp.utils.StreamUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Package_name:com.yunduo.huopinclientapp.api
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:23
 */
public class ClientApi {

    private  static String URL_HOST = URLS.URL_HOST;

    /**
     * 获取  注册信息  请求信息是否成功
     * @return
     */
    public static JSONObject getRegisterResult(String acc,String password) {

        JSONObject ret = null;

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userPassword", password);
        params.put("userAccount", acc);

        InputStream in = null;
        try {
            in = HttpTools._post(URLS.URL_HOST+URLS.ACTION_REGISTER_NORMAL_USER,params,null);
            byte[] bs = StreamUtils.readStream(in);
            String data = new String(bs,"utf-8");
            if(data!=null){
                return new JSONObject(data);
            }
        } catch (AppException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally{//释放内存
            params.clear();
        }
        return ret;
    }
}
