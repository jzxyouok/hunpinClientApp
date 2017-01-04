package com.yunduo.huopinclientapp.api;

/**
 * Package_name:com.edu.fangqiu.gkww.client
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/13  14:57
 * 封装 所有对的   URL
 */

public final class URLs {

    public final static String HTTP = "http://";

    public static final String SERVER_IP = "www.521geek.com:8888/CallCallStore/app";

    public static final String URL_SPILT = "/";

    //发送验证码
    public static final String URL_SENDVERFIY = HTTP + SERVER_IP   +
            URL_SPILT + "/SingleSendSms";
    //登录
    public static final String URL_LOGIN = HTTP + SERVER_IP   +
            URL_SPILT + "/app_loginCustomerAction";
    //注册
    public static final String URL_REGISTER =  HTTP + SERVER_IP   +
            URL_SPILT + "/app_registerCustomerAction";



}