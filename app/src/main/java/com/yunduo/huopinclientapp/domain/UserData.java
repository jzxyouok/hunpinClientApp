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

    /**
     * userPassword : 21232f297a57a5a743894a0e4a801fc3
     * userPhoto : defaultHead.png
     * userPayPassword : ???
     * userRealName : ???
     * userScore : 0
     * userName : 5589771??
     * userId : 1
     * userRegisterTime : 1474700182303
     * userToken : c2bdacf31ee052a534d870e65d571fce5e9f99d7
     * userAccount : 18323860738
     * userCardId : ???
     * userLevelId : 1
     */
    private String userToken; //
    private int userId; //id

    private String userAccount; //账号
    private String userPassword; //用户密码

    private String userPhoto;  //头像

    private String userPayPassword; //用户支付密码
    private String userRealName; //用户

    private int userScore; //积分
    private String userName; //用户名

    private long userRegisterTime;

    private String userCardId;

    private int userLevelId;//

    public UserData() {
        super();
    }


    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserPayPassword() {
        return userPayPassword;
    }

    public void setUserPayPassword(String userPayPassword) {
        this.userPayPassword = userPayPassword;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(long userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public int getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(int userLevelId) {
        this.userLevelId = userLevelId;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userPassword='" + userPassword + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userPayPassword='" + userPayPassword + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userScore=" + userScore +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", userRegisterTime=" + userRegisterTime +
                ", userToken='" + userToken + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userCardId='" + userCardId + '\'' +
                ", userLevelId=" + userLevelId +
                '}';
    }
}
