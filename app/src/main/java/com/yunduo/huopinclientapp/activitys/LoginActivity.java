package com.yunduo.huopinclientapp.activitys;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.api.ClientApi;
import com.yunduo.huopinclientapp.utils.ActionBarManager;
import com.yunduo.huopinclientapp.utils.InputVerfiyUtil;
import com.yunduo.huopinclientapp.utils.JSONParseUtil;
import com.yunduo.huopinclientapp.utils.LoginUtil;
import com.yunduo.huopinclientapp.utils.MyToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView regTv,account,password;

    private Button logBtn;

    private ImageView iconBack;

    private TextView forgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_viphuopin);

        ActionBarManager.getInstance().initSystemBarTran(true,this,R.color.login_actionbar_color);

        initView();
    }

    private void initView() {
        regTv = (TextView) findViewById(R.id.title_register);
        account = (TextView) findViewById(R.id.et_phone_number);
        password = (TextView) findViewById(R.id.et_pwd);

        forgetPwd = (TextView) findViewById(R.id.return_pwd);
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
            //---
            case R.id.title_back:
//                //返回
                finish();
                break;

            case R.id.btn_login:
                //获取  登录  账号和  密码  登录账户
                String acc  = account.getText().toString().trim();
                String pwd = password.getText().toString().trim();
//                if(InputVerfiyUtil.verfiyPhoneNum(this,acc) && InputVerfiyUtil.verfiyPwd(this,pwd) &&
//                        !LoginUtil.isLogin(LoginActivity.this)) { //多加判断一次  防止第三方跳转  确定当前用户未登录
                    login("18317726009","admin");
//                }
                break;

            case R.id.title_register:
                //跳转到注册界面
                if(!LoginUtil.isLogin(LoginActivity.this)){ //多加判断一次  防止第三方跳转  确定当前用户未登录
                    startActivity(new Intent(this,RegisterActivity.class));
                }else{
                    MyToastUtil.ToastIncenter(this,"请先退出，再注册");
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

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case ClientApi.LOGIN_SUCCESS:
                    try {
                        String str = (String) msg.obj;
                        JSONObject object = new JSONObject(str);
                        if(object.getInt("resultCode")==0){
                            LoginUtil.saveUserLoginData(LoginActivity.this,JSONParseUtil.getUseBean(object.getString("data")));
                            finish();
                        }else {
                            MyToastUtil.ToastInLow(LoginActivity.this,object.getString("resultMessage"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.i("info","json解析异常");
                    }
                    break;
                case ClientApi.LOGIN_OR_REGISTER_ERROR:
                    MyToastUtil.ToastIncenter(LoginActivity.this,"登录失败");
                    break;
                default:
                    break;
            }
        }
    };

    //普通登录：
    private void login(String acc, String pwd) {
        LoginUtil.toLogin(this,acc,pwd,null,handler,"login");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
