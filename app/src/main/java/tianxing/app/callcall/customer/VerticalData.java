package tianxing.app.callcall.customer;

import tianxing.app.callcall.customer.domain.BusinessBean;

import java.util.ArrayList;

/**
 * Package_name:com.yunduo.huopinclientapp
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/01/16  13:42
 * 虚拟的数据类
 */
public class VerticalData {

    /**
     * 获取 娱乐商家数据信息
     * @return
     */
    public static ArrayList<BusinessBean> getEnteainmentList(){
        ArrayList<BusinessBean> list = new ArrayList<>();

        for(int i = 0;i<10;i++){
            BusinessBean entertainmentBusiness = new BusinessBean();

            entertainmentBusiness.setBusinessName("商家名称"+i);
            entertainmentBusiness.setImageUrl("http://p0.meituan.net/460.280/deal/04573ebf3d16d94605f6097b7fdeda89194047.jpg");
            list.add(entertainmentBusiness);
        }
        return  list;
    }

    /**
     * 获取 吃饭商家数据信息
     * @return
     */
    public static ArrayList<BusinessBean> getEatBuiness(){
        ArrayList<BusinessBean> list = new ArrayList<>();

        for(int i = 0;i<10;i++){
            BusinessBean entertainmentBusiness = new BusinessBean();

            entertainmentBusiness.setBusinessName("商家名称"+i);
            entertainmentBusiness.setImageUrl("http://p0.meituan.net/460.280/deal/b14653bd0970153ad64a19a39ba234fa18411.jpg");
            list.add(entertainmentBusiness);
        }
        return  list;
    }



}
