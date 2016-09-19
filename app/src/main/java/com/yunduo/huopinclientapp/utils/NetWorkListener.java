package com.yunduo.huopinclientapp.utils;

/**
 * Created by Administrator on 2016/6/14.
 * 网络监听接口   成功失败
 */
public interface NetWorkListener {
    public void onSuccess(String result) ;
    public void onError() ;
}
