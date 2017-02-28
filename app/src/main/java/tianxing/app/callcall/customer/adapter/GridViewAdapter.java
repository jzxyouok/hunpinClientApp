package tianxing.app.callcall.customer.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.domain.FirstGridViewBean;
import tianxing.app.callcall.customer.utils.MyToastUtil;

/**
 * Package_name:tianxing.app.callcall.customer.adapter
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/02/28  22:22
 */

public class GridViewAdapter extends BaseAdapter {

    private ArrayList<FirstGridViewBean> lists;
    private Context context;

    public GridViewAdapter(Context context, ArrayList<FirstGridViewBean> list) {
        this.lists = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size() ==0 ? 0:lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.first_fragment_gridview_item,
                    null,false);
            holder.imageView = (ImageView) view.findViewById(R.id.category_bg);
            holder.textView = (TextView) view.findViewById(R.id.category_txt);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        Picasso.with(context).load(lists.get(i).getCatelogSecondImgSrc()).into(holder.imageView);
        holder.textView.setText(lists.get(i).getCatelogSecondName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyToastUtil.ToastInLow(context,"点击了：" + i);
            }
        });

        return view;
    }
    private class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}