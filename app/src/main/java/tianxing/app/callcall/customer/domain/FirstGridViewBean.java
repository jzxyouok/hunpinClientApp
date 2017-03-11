package tianxing.app.callcall.customer.domain;

/**
 * Package_name:tianxing.app.callcall.customer.domain
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/02/28  00:20
 */
public class FirstGridViewBean extends BaseEntity {
    /**
     * id : 1
     * catelogFirstId : 1
     * catelogSecondImgSrc : data/catelog/happy/happy_default.png
     * catelogSecondId : 1
     * catelogSecondName : 火锅
     */
    private int id;
    private int catelogFirstId;
    private String catelogSecondImgSrc;
    private int catelogSecondId;
    private String catelogSecondName;

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

    public String getCatelogSecondImgSrc() {
        return catelogSecondImgSrc;
    }

    public void setCatelogSecondImgSrc(String catelogSecondImgSrc) {
        this.catelogSecondImgSrc = catelogSecondImgSrc;
    }

    public int getCatelogSecondId() {
        return catelogSecondId;
    }

    public void setCatelogSecondId(int catelogSecondId) {
        this.catelogSecondId = catelogSecondId;
    }

    public String getCatelogSecondName() {
        return catelogSecondName;
    }

    public void setCatelogSecondName(String catelogSecondName) {
        this.catelogSecondName = catelogSecondName;
    }

    @Override
    public String toString() {
        return "FirstGridViewBean{" +
                "id=" + id +
                ", catelogFirstId=" + catelogFirstId +
                ", catelogSecondImgSrc='" + catelogSecondImgSrc + '\'' +
                ", catelogSecondId=" + catelogSecondId +
                ", catelogSecondName='" + catelogSecondName + '\'' +
                '}';
    }
}
