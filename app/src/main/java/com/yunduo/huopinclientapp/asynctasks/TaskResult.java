package com.yunduo.huopinclientapp.asynctasks;

/**
 * Package_name:com.yunduo.huopinclientapp.asynctasks
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:07
 * 异步任务返回结果的   封装类
 */
public class TaskResult {

    /**
     * 异步任务唯一标识，每一个异步任务的标识都不同
     */
    public int action;

    /**
     * 任意数据类型，服务器  返回的数据对象
     */
    public Object data;

}

