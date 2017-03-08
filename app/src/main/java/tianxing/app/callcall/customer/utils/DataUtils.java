package tianxing.app.callcall.customer.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tianxing.app.callcall.customer.domain.DataBean;
import tianxing.app.callcall.customer.domain.FirstGridViewBean;

/**
 * Package_name:tianxing.app.callcall.customer.utils
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/07  22:14
 */

public final class DataUtils {


    public static List<FirstGridViewBean> getFirstFragGVData(JSONArray array) {
        List<FirstGridViewBean> beanAll = new ArrayList<FirstGridViewBean>();
        try {
            JSONObject js0 = array.getJSONObject(0);
            JSONObject js1 = array.getJSONObject(1);

            JSONArray array1 = js0.getJSONArray("menuItemList");
            JSONArray array2 = js1.getJSONArray("menuItemList");

            List<FirstGridViewBean>
                    bean1 = GsonConvertUtils.getObjs(array1.toString());
            List<FirstGridViewBean>
                    bean2 = GsonConvertUtils.getObjs(array2.toString());

            if (bean1 != null && bean1.size() >= 4 && bean2 != null
                    && bean2.size() >= 4) {
                beanAll.add(bean1.get(0));
                beanAll.add(bean1.get(1));
                beanAll.add(bean1.get(2));
                beanAll.add(bean1.get(3));

                beanAll.add(bean2.get(0));
                beanAll.add(bean2.get(1));
                beanAll.add(bean2.get(2));
                beanAll.add(bean2.get(3));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return beanAll;
    }
}
