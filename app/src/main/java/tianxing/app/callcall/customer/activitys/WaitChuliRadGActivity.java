package tianxing.app.callcall.customer.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tianxing.app.callcall.customer.Constants;
import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.VerticalData;
import tianxing.app.callcall.customer.adapter.MListViewAdapter;
import tianxing.app.callcall.customer.adapter.ViewHolder;
import tianxing.app.callcall.customer.domain.FirstRecycleBean;
import tianxing.app.callcall.customer.utils.ActionBarManager;

public class WaitChuliRadGActivity extends AppCompatActivity implements View.OnClickListener {

    private String auth;

    private ImageView ic_back;
    private TextView title;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_chuli_rad_g);
        ic_back = (ImageView) findViewById(R.id.ic_back);
        title = (TextView) findViewById(R.id.title_name);
        listView = (ListView) findViewById(R.id.listView);

        ActionBarManager.getInstance().initSystemBarTran(true, this, R.color.white);

        Bundle bundle = getIntent().getExtras();
        auth = bundle.getString("aut");

        initView(auth);
        ic_back.setOnClickListener(this);
    }

    /**
     * 根据标识   初始化数据：
     *
     * @param auth
     */
    private void initView(String auth) {
        switch (auth) {
            case Constants.Wait_pay: //待付款
                title.setText("待付款");
                initWPayListView();
                break;
            case Constants.Wait_commennt: //带评价
                title.setText("带评价");
                initWCommentListView();
                break;
            case Constants.Wait_backPay: //回退
                title.setText("回退");
                initWBackPayListView();
                break;
            case Constants.Wait_history_pay: //历史消费
                title.setText("历史消费");
                initPayHistoryListView();
                break;
            default:
                break;
        }
    }

    /**
     * 待支付 ListView
     */
    private void initWPayListView() {
        ArrayList<FirstRecycleBean> beans = VerticalData.getFirstRecycleData();
        MListViewAdapter adapter = new MListViewAdapter<FirstRecycleBean>(
                this, beans,R.layout.wait_pay_list_item_view,
                new ViewHolder<FirstRecycleBean>(){
                    ImageView imageView;
                    TextView title,xiadanTime,price;
                    TextView btn;
                    @Override
                    public void findView(View itemView, int position) {
                        btn = (TextView) itemView.findViewById(R.id.txt_btn);
                        imageView = (ImageView) itemView.findViewById(R.id.shangdian_img_icon);
                        price = (TextView) itemView.findViewById(R.id.now_price);
                        xiadanTime = (TextView) itemView.findViewById(R.id.xiadan_time);
                        title = (TextView) itemView.findViewById(R.id.shangdian_title);
                    }
                    @Override
                    public void setData(List<FirstRecycleBean> allDatas, int currPosition) {
                        Picasso.with(WaitChuliRadGActivity.this).load(allDatas.get(currPosition).getShopImgPath()).into(imageView);
                        xiadanTime.setText(new Date().toLocaleString());
                        price.setText("$2323-" + currPosition);
                        btn.setText("付款");
                        title.setText(allDatas.get(currPosition).getShopName());
                    }
        });
        listView.setAdapter(adapter);
    }

    /**
     * 待评价 ListView
     */
    private void initWCommentListView() {
        ArrayList<FirstRecycleBean> beans = VerticalData.getFirstRecycleData();
        MListViewAdapter adapter = new MListViewAdapter<FirstRecycleBean>(
                this, beans,R.layout.wait_pay_list_item_view,
                new ViewHolder<FirstRecycleBean>(){
                    ImageView imageView;
                    TextView title,xiadanTime,price;
                    TextView btn;
                    @Override
                    public void findView(View itemView, int position) {
                        btn = (TextView) itemView.findViewById(R.id.txt_btn);
                        imageView = (ImageView) itemView.findViewById(R.id.shangdian_img_icon);
                        price = (TextView) itemView.findViewById(R.id.now_price);
                        xiadanTime = (TextView) itemView.findViewById(R.id.xiadan_time);
                        title = (TextView) itemView.findViewById(R.id.shangdian_title);
                    }
                    @Override
                    public void setData(List<FirstRecycleBean> allDatas, int currPosition) {
                        Picasso.with(WaitChuliRadGActivity.this).load(allDatas.get(currPosition).getShopImgPath()).into(imageView);
                        xiadanTime.setText(new Date().toLocaleString());
                        price.setText("$2323-" + currPosition);
                        btn.setText("评价");
                        title.setText(allDatas.get(currPosition).getShopName());
                    }
                });
        listView.setAdapter(adapter);
    }

    /**
     * 回退款 ListView
     */
    private void initWBackPayListView() {
        ArrayList<FirstRecycleBean> beans = VerticalData.getFirstRecycleData();
        MListViewAdapter adapter = new MListViewAdapter<FirstRecycleBean>(
                this, beans,R.layout.wait_pay_list_item_view,
                new ViewHolder<FirstRecycleBean>(){
                    ImageView imageView;
                    TextView title,xiadanTime,price;
                    TextView btn;
                    @Override
                    public void findView(View itemView, int position) {
                        btn = (TextView) itemView.findViewById(R.id.txt_btn);
                        imageView = (ImageView) itemView.findViewById(R.id.shangdian_img_icon);
                        price = (TextView) itemView.findViewById(R.id.now_price);
                        xiadanTime = (TextView) itemView.findViewById(R.id.xiadan_time);
                        title = (TextView) itemView.findViewById(R.id.shangdian_title);
                    }
                    @Override
                    public void setData(List<FirstRecycleBean> allDatas, int currPosition) {
                        Picasso.with(WaitChuliRadGActivity.this).load(allDatas.get(currPosition).getShopImgPath()).into(imageView);
                        xiadanTime.setText(new Date().toLocaleString());
                        price.setText("$2323-" + currPosition);
                        btn.setText("退款");
                        title.setText(allDatas.get(currPosition).getShopName());
                    }
                });
        listView.setAdapter(adapter);
    }

    /**
     * 历史消费 ListView
     */
    private void initPayHistoryListView() {
        ArrayList<FirstRecycleBean> beans = VerticalData.getFirstRecycleData();
        MListViewAdapter adapter = new MListViewAdapter<FirstRecycleBean>(
                this, beans,R.layout.wait_pay_list_item_view,
                new ViewHolder<FirstRecycleBean>(){
                    ImageView imageView;
                    TextView title,xiadanTime,price;
                    TextView btn;
                    @Override
                    public void findView(View itemView, int position) {
                        btn = (TextView) itemView.findViewById(R.id.txt_btn);
                        imageView = (ImageView) itemView.findViewById(R.id.shangdian_img_icon);
                        price = (TextView) itemView.findViewById(R.id.now_price);
                        xiadanTime = (TextView) itemView.findViewById(R.id.xiadan_time);
                        title = (TextView) itemView.findViewById(R.id.shangdian_title);
                    }
                    @Override
                    public void setData(List<FirstRecycleBean> allDatas, int currPosition) {
                        Picasso.with(WaitChuliRadGActivity.this).load(allDatas.get(currPosition).getShopImgPath()).into(imageView);
                        xiadanTime.setText(new Date().toLocaleString());
                        price.setText("$2323-" + currPosition);
                        btn.setText("历史消费");
                        title.setText(allDatas.get(currPosition).getShopName());
                    }
                });
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ic_back:
                finish();
                break;
            default:
                break;
        }
    }
}
