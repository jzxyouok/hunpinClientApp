package tianxing.app.callcall.customer.domain;

import java.util.ArrayList;

/**
 * Package_name:tianxing.app.callcall.customer.domain
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/05  23:19
 */

public class DataBean<T> {

    public int id;

    public int menuId;

    public String menuTitle;

    public T menuItemList;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", menuTitle='" + menuTitle + '\'' +
                ", menuItemList=" + menuItemList +
                '}';
    }
}
