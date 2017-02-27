package tianxing.app.callcall.customer.domain;

/**
 * Package_name:com.yunduo.huopinclientapp.domain
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/01/16  13:50
 *
 * 首页  fragment中  商家实体类
 */
public class BusinessBean extends BaseEntity {

    //商家照片和  和商家名称  暂时为假的数据
    private String imageUrl;
    private String businessName;

    private boolean isCheck;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @Override
    public String toString() {
        return "BusinessBean{" +
                "imageUrl='" + imageUrl + '\'' +
                ", businessName='" + businessName + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}
