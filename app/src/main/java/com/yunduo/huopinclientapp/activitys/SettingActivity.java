package com.yunduo.huopinclientapp.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.utils.ActionBarManager;
import com.yunduo.huopinclientapp.utils.DialogUtil;

/**
 * 设置   个人信息
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;

    private RelativeLayout updateSelfData;

    private RelativeLayout clearCache;

    private RelativeLayout servicPhone;

    private RelativeLayout aboutUs;

    private RelativeLayout exitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBarManager.getInstance().initSystemBarTran(true,this,R.color.red_ff556d);

        initView();
    }

    private void initView() {
        //初始化  数据
        back = (ImageView) findViewById(R.id.title_back);
        updateSelfData = (RelativeLayout) findViewById(R.id.rl_update);
        clearCache = (RelativeLayout) findViewById(R.id.rl_clean);
        servicPhone = (RelativeLayout) findViewById(R.id.rl_service);
        aboutUs = (RelativeLayout) findViewById(R.id.rl_about);
        exitLogin = (RelativeLayout) findViewById(R.id.exit_login);

        back.setOnClickListener(this);
        updateSelfData.setOnClickListener(this);
        clearCache.setOnClickListener(this);
        servicPhone.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
        exitLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.title_back:
                //返回
                finish();

                break;
            case R.id.rl_update:
                //  更新资料
                startActivity(new Intent(this,UpdateDataActivity.class));
                break;
            case R.id.rl_clean:
                //清除缓存

                break;
            case R.id.rl_service:
                //客服电话     弹出对话框

                break;
            case R.id.rl_about:
                //关于我们
                startActivity(new Intent(this,AboutUSActivity.class));
                break;
            case R.id.exit_login:
                //退出登录
                DialogUtil.getExitDialog(this,"确认退出？").show();
                break;
        }
    }
}
