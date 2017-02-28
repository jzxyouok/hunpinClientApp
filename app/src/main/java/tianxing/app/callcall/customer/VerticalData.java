package tianxing.app.callcall.customer;

import java.util.ArrayList;

import tianxing.app.callcall.customer.domain.FirstGridViewBean;
import tianxing.app.callcall.customer.domain.FirstRecycleBean;

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
    public static ArrayList<FirstGridViewBean> getGridViewList() {

        ArrayList<FirstGridViewBean> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            FirstGridViewBean gv = new FirstGridViewBean();

            gv.setCatelogSecondImgSrc("http://www.qqleju.com/uploads/allimg/160622/22-101309_76.jpg");
            gv.setCatelogSecondName("类别" + i);

            list.add(gv);
        }

        return list;
    }

    /**
     * 首页 RecycleView 数据：
     * @return
     */
    public static ArrayList<FirstRecycleBean> getFirstRecycleData() {

        ArrayList<FirstRecycleBean> beanArrayList = new ArrayList<>();

        for(int i=0;i<15;i++){
            FirstRecycleBean firstRecycleBean = new FirstRecycleBean();

            firstRecycleBean.setShopName("夏威夷海滩"+i);
            firstRecycleBean.setPingLunCount(i);  //评论数
            firstRecycleBean.setShopDiscountRate(i); //评论  数

            beanArrayList.add(firstRecycleBean);
        }

        return beanArrayList;
    }
}
