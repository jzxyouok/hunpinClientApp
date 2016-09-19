package com.yunduo.huopinclientapp.activitys;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yunduo.huopinclientapp.ActManager;
import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.utils.MyToast;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
                finish();
                break;

            case R.id.btn_login:
                //获取  登录账号和密码  登录账户
                String acc  = account.getText().toString().trim();
                String pwd = password.getText().toString().trim();

                if(TextUtils.isEmpty(acc)){
                    MyToast.ToastIncenter(this,"账号不准为空");
                    return;
                }
                if(!acc.matches("")){

                }
                if(acc.length()<5){
                    MyToast.ToastIncenter(this,"账号输入不合法！");
                    return;
                }
                if(TextUtils.isEmpty(pwd)){
                    MyToast.ToastIncenter(this,"账号不准为空!");
                    return;
                }
                if (pwd.length()<6){
                    MyToast.ToastIncenter(this,"密码不能小于6位！");
                    return;
                }

                if(true) { //多加判断一次  防止第三方跳转  确定当前用户未登录
                    login(acc,pwd);
                }

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

    //普通登录：
    private void login(String acc, String pwd) {
        //登陆成功   保存数据  销毁当前 activity

    }
}
