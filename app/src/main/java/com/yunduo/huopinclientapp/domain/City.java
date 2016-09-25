package com.yunduo.huopinclientapp.domain;

/**
 * Package_name:com.yunduo.huopinclientapp.domain
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/22  13:49
 *
 * 封装  软件 所在地点的  实体类
 */
public final class City extends BaseEntity{

    public City(){
        super();
    }

    private String cityName;//软件 使用所在城市名称

    private String longItude;//用户所在经度

    private String latitude;//用户  所在维度

    //  -------  测试用
    public City(String cityName, String longItude, String latitude) {
        this.cityName = cityName;
        this.longItude = longItude;
        this.latitude = latitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongItude() {
        return longItude;
    }

    public void setLongItude(String longItude) {
        this.longItude = longItude;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", longItude='" + longItude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
