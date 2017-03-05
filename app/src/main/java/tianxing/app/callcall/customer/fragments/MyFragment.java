package tianxing.app.callcall.customer.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

import tianxing.app.callcall.customer.Constants;
import tianxing.app.callcall.customer.activitys.WaitChuliRadGActivity;
import tianxing.app.callcall.customer.utils.LoginUtil;
import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.activitys.LoginActivity;
import tianxing.app.callcall.customer.activitys.SettingActivity;
import tianxing.app.callcall.customer.utils.MyToastUtil;

import java.util.ArrayList;


/**
 * 我的
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private View view;

    private RadioButton my_pay,my_commont,my_nopay,my_historypay;

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);
        initView();
        return view;
    }

    public void initView() {
        my_pay = (RadioButton) view.findViewById(R.id.my_pay);
        my_commont = (RadioButton) view.findViewById(R.id.my_commont);
        my_nopay = (RadioButton) view.findViewById(R.id.my_nopay);
        my_historypay = (RadioButton) view.findViewById(R.id.my_historypay);

        initListener();
    }

    /**
     * view的 单击事件：
     */
    private void initListener() {

        my_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WaitChuliRadGActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aut",Constants.Wait_pay);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        my_commont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WaitChuliRadGActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aut",Constants.Wait_commennt);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        my_nopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WaitChuliRadGActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aut",Constants.Wait_backPay);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        my_historypay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WaitChuliRadGActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("aut",Constants.Wait_history_pay);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            default:break;
        }
    }

}
