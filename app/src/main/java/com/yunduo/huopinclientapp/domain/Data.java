package com.yunduo.huopinclientapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Package_name:com.yunduo.huopinclientapp.domain
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/11/25  22:32
 */
public class Data extends BaseEntity implements Serializable {

    private String Title;
    private List<String> urls;

    private String dataInfo;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(String dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Title='" + Title + '\'' +
                ", urls=" + urls +
                ", dataInfo='" + dataInfo + '\'' +
                '}';
    }
}
