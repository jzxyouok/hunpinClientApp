package com.yunduo.huopinclientapp.activitys;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yunduo.huopinclientapp.ActManager;
import com.yunduo.huopinclientapp.R;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView regTv,account,password;

    private Button logBtn;

    private ImageView iconBack,forgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        regTv = (TextView) findViewById(R.id.title_register);
        account = (TextView) findViewById(R.id.et_phone_number);
        password = (TextView) findViewById(R.id.et_pwd);

        forgetPwd = (ImageView) findViewById(R.id.return_pwd);
        logBtn = (Button) findViewById(R.id.btn_login);
        iconBack = (ImageView) findViewById(R.id.title_back);

        iconBack.setOnClickListener(this);
        regTv.setOnClickListener(this);
        logBtn.setOnClickListener(this);
        forgetPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //注册界面
        switch(view.getId()){

            case R.id.title_back:
                //返回
                ActManager.getActivity(LoginActivity.class).finish();
                break;

            case R.id.btn_login:
                //获取  登录账号和密码  登录账户  TODO

                break;

            case R.id.title_register:
                //跳转到注册界面  TODO
                if(true){ //多加判断一次  防止第三方跳转  确定当前用户未登录
                    startActivity(new Intent(this,RegisterActivity.class));
                }
                break;

            case R.id.return_pwd:
                //重置密码
                startActivity(new Intent(this,ForgetActivity.class));

                break;

            default:
                break;
        }
    }
}
