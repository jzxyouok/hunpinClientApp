package tianxing.app.callcall.customer.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

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

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);

        return view;
    }

    public void initView() {
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            default:break;
        }
    }

}
