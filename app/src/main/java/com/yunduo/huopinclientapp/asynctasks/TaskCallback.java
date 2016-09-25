package com.yunduo.huopinclientapp.asynctasks;

/**
 * Package_name:com.yunduo.huopinclientapp.asynctasks
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/20  23:06
 * 异步任务回调接口
 */
public interface TaskCallback {

    /**
     * 当异步任务执行完成的时候，会回调这个方法，将数据结果，传递给相应的实现类
     *
     * @param result 返回的结果
     */
    void onTaskFinished(TaskResult result);

}
