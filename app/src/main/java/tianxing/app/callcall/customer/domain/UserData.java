package tianxing.app.callcall.customer.domain;

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
     * customerScore : 0
     * customerPhoto : customers\18317726009\defaultHead.png
     * isCertification : false
     * customerToken : 532ff9d5a7dcc69d8e39e44b14f43bd1480153707708
     * customerSex : -1
     * customerAccount : 18317726009
     * customerPayPassword : 123456
     * customerRegisterTime : 1479617804587
     * customerId : 1
     * customerLevelId : 1
     * customerRealName : 未填写
     * customerCardId : 未填写
     * customerNikeName : 新注册用户
     * customerPassword : 532ff9d5a7dcc69d8e39e44b14f43bd
     */

    private int customerScore;
    private String customerPhoto;
    private boolean isCertification;
    private String customerToken;
    private int customerSex;
    private String customerAccount;
    private String customerPayPassword;
    private long customerRegisterTime;
    private int customerId;
    private int customerLevelId;
    private String customerRealName;
    private String customerCardId;
    private String customerNikeName;
    private String customerPassword;

    public int getCustomerScore() {
        return customerScore;
    }

    public void setCustomerScore(int customerScore) {
        this.customerScore = customerScore;
    }

    public String getCustomerPhoto() {
        return customerPhoto;
    }

    public void setCustomerPhoto(String customerPhoto) {
        this.customerPhoto = customerPhoto;
    }

    public boolean isIsCertification() {
        return isCertification;
    }

    public void setIsCertification(boolean isCertification) {
        this.isCertification = isCertification;
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

    public int getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(int customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerPayPassword() {
        return customerPayPassword;
    }

    public void setCustomerPayPassword(String customerPayPassword) {
        this.customerPayPassword = customerPayPassword;
    }

    public long getCustomerRegisterTime() {
        return customerRegisterTime;
    }

    public void setCustomerRegisterTime(long customerRegisterTime) {
        this.customerRegisterTime = customerRegisterTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerLevelId() {
        return customerLevelId;
    }

    public void setCustomerLevelId(int customerLevelId) {
        this.customerLevelId = customerLevelId;
    }

    public String getCustomerRealName() {
        return customerRealName;
    }

    public void setCustomerRealName(String customerRealName) {
        this.customerRealName = customerRealName;
    }

    public String getCustomerCardId() {
        return customerCardId;
    }

    public void setCustomerCardId(String customerCardId) {
        this.customerCardId = customerCardId;
    }

    public String getCustomerNikeName() {
        return customerNikeName;
    }

    public void setCustomerNikeName(String customerNikeName) {
        this.customerNikeName = customerNikeName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "customerScore=" + customerScore +
                ", customerPhoto='" + customerPhoto + '\'' +
                ", isCertification=" + isCertification +
                ", customerToken='" + customerToken + '\'' +
                ", customerSex=" + customerSex +
                ", customerAccount='" + customerAccount + '\'' +
                ", customerPayPassword='" + customerPayPassword + '\'' +
                ", customerRegisterTime=" + customerRegisterTime +
                ", customerId=" + customerId +
                ", customerLevelId=" + customerLevelId +
                ", customerRealName='" + customerRealName + '\'' +
                ", customerCardId='" + customerCardId + '\'' +
                ", customerNikeName='" + customerNikeName + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                '}';
    }
}
