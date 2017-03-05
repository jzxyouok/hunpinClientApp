package tianxing.app.callcall.customer.adapter;

import android.view.View;

import java.util.List;

/**
 * Package_name:tianxing.app.callcall.customer.adapter
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/05  18:25
 */

public abstract class ViewHolder<T> {

    public abstract void findView(View itemView, int position);
    public abstract void setData(List<T> allDatas, int currPosition);
}
