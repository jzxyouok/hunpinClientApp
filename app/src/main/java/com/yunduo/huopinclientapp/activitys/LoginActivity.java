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
import com.yunduo.huopinclientapp.domain.City;
import com.yunduo.huopinclientapp.domain.UserData;
import com.yunduo.huopinclientapp.utils.InputVerfiyUtil;
import com.yunduo.huopinclientapp.utils.LoginUtil;
import com.yunduo.huopinclientapp.utils.MyToast;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView regTv,account,password;

    private Button logBtn;

    private ImageView iconBack,forgetPwd;


    private static final int ACTIV_REGISTER = 1; //打开  注册  界面的标识

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
                //获取  登录  账号和  密码  登录账户
                String acc  = account.getText().toString().trim();
                String pwd = password.getText().toString().trim();

                InputVerfiyUtil.verfiyPhoneNum(this,acc);
                InputVerfiyUtil.verfiyPwd(this,pwd);

                if(!LoginUtil.isLogin(LoginActivity.this)) { //多加判断一次  防止第三方跳转  确定当前用户未登录
                    login(acc,pwd);
                }else{
                    MyToast.ToastIncenter(this,"当前已登录");
                }

                break;

            case R.id.title_register:
                //跳转到注册界面
                if(!LoginUtil.isLogin(LoginActivity.this)){ //多加判断一次  防止第三方跳转  确定当前用户未登录
                    startActivity(new Intent(this,RegisterActivity.class));
                }else{
                    MyToast.ToastIncenter(this,"请先退出，再注册");
                }
                break;

            case R.id.return_pwd:
                //重置密码
                startActivityForResult(new Intent(this,ForgetActivity.class),ACTIV_REGISTER);
                break;

            default:
                break;
        }
    }

    //普通登录：
    private void login(String acc, String pwd) {
        //登陆成功   保存数据   销毁当前 activity  网络登录

        //TODO  创建异步任务   请求数据

        UserData userData = new UserData();
        userData.setUserAccount("18513667437");
        userData.setUserName("赵强");
        userData.setUserCardId("412343231245656433");
        userData.setCity(new City("北京","166.43","35.09"));

        //
        if(LoginUtil.saveUserLoginData(LoginActivity.this, userData)){
            MyToast.ToastIncenter(this,"登陆成功");
            finish();//结束  当前activity
        }else{
            MyToast.ToastIncenter(this,"登录失败");
        }
    }

    //微信登录   qq第三方登录
    private void weChatLogin(){

    }

    //微信登录   qq第三方登录
    private void qqLogin(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断   注册返回数据  是否成功
        switch (requestCode){
            case ACTIV_REGISTER:
                //注册界面  返回数据


                break;
            default:break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
