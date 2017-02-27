package tianxing.app.callcall.customer;

import java.util.ArrayList;

import tianxing.app.callcall.customer.domain.GVCategory;

/**
 * Package_name:com.yunduo.huopinclientapp
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/01/16  13:42
 * 虚拟的数据类
 */
public class VerticalData {

    /**
     * 获取 首页 分类列表数据
     * @return
     */
    public static ArrayList<GVCategory> getGridViewList() {

        ArrayList<GVCategory> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            GVCategory gv = new GVCategory();

            gv.setCatelogSecondImgSrc("http://www.qqleju.com/uploads/allimg/160622/22-101309_76.jpg");
            gv.setCatelogSecondName("类别" + i);

            list.add(gv);
        }

        return list;
    }
}
