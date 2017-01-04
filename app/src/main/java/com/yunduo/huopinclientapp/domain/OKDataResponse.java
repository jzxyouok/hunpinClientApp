package com.yunduo.huopinclientapp.domain;

/**
 * Package_name:com.edu.fangqiu.gkww.bean
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/14  15:30
 * 所有  固定格式  请求回来的数据
 */
public class OKDataResponse<T> extends BaseEntity{

    private static final long serialVersionUID = 5213230387175987834L;

    private Object other;

    private boolean isOK;

    private int resultCode;

    private T data;

    private String resultMessage;

}
