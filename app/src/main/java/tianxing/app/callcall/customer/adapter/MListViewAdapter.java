package tianxing.app.callcall.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


/**
 * Package_name:tianxing.app.callcall.customer.adapter
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/05  13:57
 */

public class MListViewAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> beans;

    private int resId;
    private ViewHolder holder;

    public MListViewAdapter(Context context,
                            List<T> beans, int resId, ViewHolder<T> holder) {
        this.context = context;
        this.beans = beans;
        this.resId = resId;
        this.holder = holder;
    }

    @Override
    public int getCount() {
        return beans.size()==0?0:beans.size();
    }

    @Override
    public Object getItem(int i) {
        return beans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(resId,viewGroup,false);

            holder.findView(convertView,i);

            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();

        holder.setData(beans,i);

        return convertView;
    }

}
