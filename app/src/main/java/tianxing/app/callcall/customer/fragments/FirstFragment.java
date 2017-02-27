package tianxing.app.callcall.customer.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.VerticalData;
import tianxing.app.callcall.customer.domain.GVCategory;

/**
 * 首页
 */
public class FirstFragment extends BaseFragment {

    private RecyclerView first_fragment_recycle_view;
    private GridView first_fragment_gridview;

    public FirstFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        first_fragment_recycle_view = (RecyclerView) view.findViewById(R.id.first_fragment_recycle_view);
        first_fragment_gridview = (GridView) view.findViewById(R.id.first_fragment_gridview);

        initGridView();
        initRecycleView();
        return view;
    }

    /**
     * 初始化 gridView
     */
    private void initGridView() {
        ArrayList<GVCategory> list = VerticalData.getGridViewList();
        Log.i("info",list.toString());
        GridViewAdapter adapter = new GridViewAdapter(list);
        first_fragment_gridview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * 初始化 recycleView
     */
    private void initRecycleView() {


    }

    /**
     * 适配器：
     */
    private class GridViewAdapter extends BaseAdapter{

        private ArrayList<GVCategory> lists;

        public GridViewAdapter(ArrayList<GVCategory> list) {
            this.lists = list;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null){
                holder = new ViewHolder();
                view = LayoutInflater.from(getContext()).inflate(R.layout.first_fragment_gridview_item,
                        null,false);
                holder.imageView = (ImageView) view.findViewById(R.id.category_bg);
                holder.textView = (TextView) view.findViewById(R.id.category_txt);
                view.setTag(holder);
            }
            holder = (ViewHolder) view.getTag();
            Picasso.with(getContext()).load(lists.get(i).getCatelogSecondImgSrc()).into(holder.imageView);
            holder.textView.setText(lists.get(i).getCatelogSecondName());
            return view;
        }
        private class ViewHolder{
            ImageView imageView;
            TextView textView;
        }
    }
}
