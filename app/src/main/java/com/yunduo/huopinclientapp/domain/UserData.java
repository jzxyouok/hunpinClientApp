package com.yunduo.huopinclientapp.domain;

/**
 * Package_name:com.yunduo.huopinclientapp.domain
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/22  13:18
 *
 * 用户  实体类  保存用户数据  到sp文件
 */
public final class UserData extends BaseEntity {

    public UserData() {
        super();
    }

    private String phone; // 用户电话   作为唯一标识  sp
    private String userPwd; //用户密码
    private String userNick; //用户昵称 sp
    private City userCity; //用户所在城市
    private String userCard;//用户身份证号

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public City getUserCity() {
        return userCity;
    }

    public void setUserCity(City userCity) {
        this.userCity = userCity;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "phone='" + phone + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userCity=" + userCity +
                ", userCard='" + userCard + '\'' +
                '}';
    }
}
