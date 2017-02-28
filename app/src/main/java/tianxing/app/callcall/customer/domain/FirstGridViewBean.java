package tianxing.app.callcall.customer.domain;

/**
 * Package_name:tianxing.app.callcall.customer.domain
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/02/28  00:20
 */
public class FirstGridViewBean extends BaseEntity {


    private String catelogSecondImgSrc;
    private String catelogSecondName;
    private int id;
    private int catelogFirstId;
    private int catelogSecondId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatelogFirstId() {
        return catelogFirstId;
    }

    public void setCatelogFirstId(int catelogFirstId) {
        this.catelogFirstId = catelogFirstId;
    }

    public int getCatelogSecondId() {
        return catelogSecondId;
    }

    public String getCatelogSecondName() {
        return catelogSecondName;
    }

    public void setCatelogSecondName(String catelogSecondName) {
        this.catelogSecondName = catelogSecondName;
    }

    public String getCatelogSecondImgSrc() {
        return catelogSecondImgSrc;
    }

    public void setCatelogSecondImgSrc(String catelogSecondImgSrc) {
        this.catelogSecondImgSrc = catelogSecondImgSrc;
    }

    public void setCatelogSecondId(int catelogSecondId) {
        this.catelogSecondId = catelogSecondId;
    }

    @Override
    public String toString() {
        return "GVCategory{" +
                "catelogSecondImgSrc='" + catelogSecondImgSrc + '\'' +
                ", catelogSecondName='" + catelogSecondName + '\'' +
                ", id=" + id +
                ", catelogFirstId=" + catelogFirstId +
                ", catelogSecondId=" + catelogSecondId +
                '}';
    }
}
