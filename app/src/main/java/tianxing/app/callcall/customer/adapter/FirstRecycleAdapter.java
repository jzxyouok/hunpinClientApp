package tianxing.app.callcall.customer.adapter;

import android.app.Activity;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.domain.FirstGridViewBean;
import tianxing.app.callcall.customer.domain.FirstRecycleBean;
import tianxing.app.callcall.customer.utils.MyToastUtil;

/**
 * Package_name:tianxing.app.callcall.customer.adapter
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/02/28  21:25
 */

public class FirstRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private ArrayList<FirstGridViewBean> gvlist;
    private ArrayList<FirstRecycleBean> relist;

    private static final int TYPE_GRID_HEADER = 0x92;
    private static final int TYPE_RECY_BODY = 0x98;

    public FirstRecycleAdapter(Activity activity, ArrayList<FirstGridViewBean> gvlist,
                               ArrayList<FirstRecycleBean> relist) {
        this.activity = activity;
        this.gvlist = gvlist;
        this.relist = relist;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_GRID_HEADER;
        }else {
            return TYPE_RECY_BODY;
        }
    }

    RecyclerView.ViewHolder holder = null;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        switch(viewType){
            case TYPE_GRID_HEADER:
                itemview = LayoutInflater.from(activity).inflate(R.layout.first_fragment_grid_view,null,false);
                holder = new FirstGridViewHolder(itemview);
                break;
            case TYPE_RECY_BODY:
                itemview = LayoutInflater.from(activity).inflate(R.layout.first_fragment_recyleview_item,null,false);
                holder = new FirstRecycleViewHolder(itemview);
                break;
            default:break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch(getItemViewType(position)){
            case TYPE_GRID_HEADER:
                FirstGridViewHolder firstGridViewHolder = (FirstGridViewHolder) holder;
                firstGridViewHolder.setData(position);
                break;
            case TYPE_RECY_BODY:
                FirstRecycleViewHolder firstRecycleViewHolder = (FirstRecycleViewHolder) holder;
                firstRecycleViewHolder.setData(position);

                firstRecycleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyToastUtil.ToastInLow(activity,"点击了:"+relist.get(position-1));
                    }
                });

                break;
            default:break;
        }
    }

    @Override
    public int getItemCount() {
        if (relist.size() == 0 || relist == null) {
            return 0;
        }
        return relist.size() + 1;
    }

    /**
     * 绑定 GridView
     */
    class FirstGridViewHolder extends RecyclerView.ViewHolder{

        GridView gridView;

        public FirstGridViewHolder(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.first_fragment_gridview);
        }

        /**
         * 绑定数据
         * @param position
         */
        public void setData(int position) {
            GridViewAdapter adapter = new GridViewAdapter(activity,gvlist);
            gridView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 绑定 RecycleView
     */
    class FirstRecycleViewHolder extends RecyclerView.ViewHolder{

        private ImageView shangdianIcon;
        private TextView shangdianName,huopinCount,commontCount,nowprice
                ,oldPrice,distence,discount;

        public FirstRecycleViewHolder(View itemView) {
            super(itemView);
            shangdianIcon = (ImageView) itemView.findViewById(R.id.shangdian_img);
            shangdianName = (TextView) itemView.findViewById(R.id.shangdian_title);
            huopinCount = (TextView) itemView.findViewById(R.id.huopincount);
            commontCount = (TextView) itemView.findViewById(R.id.commoncount);
            nowprice = (TextView) itemView.findViewById(R.id.nowprice);
            oldPrice = (TextView) itemView.findViewById(R.id.oldprice);
            distence = (TextView) itemView.findViewById(R.id.distence);
            discount = (TextView) itemView.findViewById(R.id.discount);
        }

        /**
         * 绑定数据
         * @param position
         */
        public void setData(int position) {
            Picasso.with(activity).load("http://www.qqleju.com/uploads/allimg/160622/22-101309_76.jpg").into(shangdianIcon);
            shangdianName.setText(relist.get(position-1).getShopName()+" positon:"+position);
            huopinCount.setText("火拼次数：1299" +position);
            commontCount.setText("评论数量:"+position);
            nowprice.setText("现价:200" +position);
            oldPrice.setText("原价:200" +position);
            distence.setText("299米" +position);
            discount.setText("8折" +position);
        }
    }
}
