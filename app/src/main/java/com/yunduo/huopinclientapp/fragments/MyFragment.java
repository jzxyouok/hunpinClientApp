package com.yunduo.huopinclientapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.activitys.LoginActivity;
import com.yunduo.huopinclientapp.activitys.SettingActivity;
import com.yunduo.huopinclientapp.utils.LoginUtil;
import com.yunduo.huopinclientapp.utils.MyToastUtil;

import java.util.ArrayList;


/**
 * 我的
 */
public class MyFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView titleTxt;
    private ImageView imgIc,icSet;

    private TextView btnRegOrlog;

    private ImageView headIcon;

    public static final int SELECT_PICTURE_REQUEST_CODE = 0x32;

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
        titleTxt = (TextView) view.findViewById(R.id.title_bar_text);
        titleTxt.setText(R.string.title_wode);
        imgIc = (ImageView) view.findViewById(R.id.my_ic_setting);
        imgIc.setVisibility(View.VISIBLE);
        icSet = (ImageView) view.findViewById(R.id.my_ic_setting);

        headIcon = (ImageView) view.findViewById(R.id.my_head_img);
        headIcon.setOnClickListener(this);

        btnRegOrlog = (TextView) view.findViewById(R.id.my_btn_reg);

        btnRegOrlog.setOnClickListener(this);
        icSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.my_head_img:
                //弹出对话框  更改头像： //TODO 判断  当前是否登录
                if(true){
                    handleSelectPicture();  //选择照片  或者  照相机
                }else{
                    MyToastUtil.ToastInLow(getActivity(),getString(R.string.had_no_login));
                }
                break;
            case R.id.my_btn_reg:
                //判断  当前  是否已经登录
                if(!LoginUtil.isLogin(getContext())){
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }else{
                    MyToastUtil.ToastInLow(getActivity(),getString(R.string.had_login));
                }
                break;

            case R.id.my_ic_setting:
                //进入设置界面
                startActivity(new Intent(getActivity(),SettingActivity.class));
                break;

            default:break;
        }
    }

    private void handleSelectPicture() {
        //打开本地相册：
        Intent intent = new Intent(getActivity(), ImageGridActivity.class);
        startActivityForResult(intent,SELECT_PICTURE_REQUEST_CODE);
    }


    @Override
    public void onActivityResult(final int requestCode, final int resultCode,
                                 final Intent data) {
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null) {
                //图片缓存 的路径
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(
                        ImagePicker.EXTRA_RESULT_ITEMS);

                Log.i("info","图片获取成功");
            }else{
                MyToastUtil.ToastInLow(getActivity(),"重置失败");
            }
        }
    }
}
