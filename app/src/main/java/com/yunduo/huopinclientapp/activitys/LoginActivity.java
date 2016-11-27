package com.yunduo.huopinclientapp.activitys;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.asynctasks.LoginAsyncTask;
import com.yunduo.huopinclientapp.asynctasks.TaskCallback;
import com.yunduo.huopinclientapp.asynctasks.TaskResult;
import com.yunduo.huopinclientapp.domain.UserData;
import com.yunduo.huopinclientapp.utils.ActionBarManager;
import com.yunduo.huopinclientapp.utils.InputVerfiyUtil;
import com.yunduo.huopinclientapp.utils.LoginUtil;
import com.yunduo.huopinclientapp.utils.MyToast;

import org.json.JSONArray;
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


    private static final int ACTIV_REGISTER = 1; //打开  注册  界面的标识

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

                if(InputVerfiyUtil.verfiyPhoneNum(this,acc) && InputVerfiyUtil.verfiyPwd(this,pwd) &&
                        !LoginUtil.isLogin(LoginActivity.this)) { //多加判断一次  防止第三方跳转  确定当前用户未登录
                    login(acc,pwd);
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

    private static final int LOGIN_SUCCESS =0 ;
    private static final int ACCOUNT_NO_EXIST =1 ;
    private static final int PWD_IS_WRONG =2;
    private static final int ACCANDPWD_ISNOT_NULL =3 ;
    private static final int LOGIN_FAIL =4 ;


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case LOGIN_SUCCESS:
                    MyToast.ToastIncenter(LoginActivity.this,"登陆成功");
                    finish();  //结束当前线程
                    break;
                case ACCOUNT_NO_EXIST:
                    MyToast.ToastIncenter(LoginActivity.this,"账户不存在");
                    break;
                case PWD_IS_WRONG:
                    MyToast.ToastIncenter(LoginActivity.this,"密码错误");
                    break;
                case ACCANDPWD_ISNOT_NULL:
                    MyToast.ToastIncenter(LoginActivity.this,"不准为空");
                    break;
                case LOGIN_FAIL:
                    MyToast.ToastIncenter(LoginActivity.this,"登录失败");
                    break;
                default:
                    break;
            }
        }
    };

    //普通登录：
    private void login(String acc, String pwd) {
        //登陆成功   保存数据   销毁当前 activity  网络登录
        new LoginAsyncTask(this,new TaskCallback(){
            @Override
            public void onTaskFinished(TaskResult result) {
                try {
                    Message msg = new Message();
                    if( result.data != null){
                        JSONArray array = (JSONArray) result.data;
                        JSONObject obj = array.getJSONObject(0);
                        String resultCode = obj.getString("resultCode");
                        switch(resultCode){
                            case "0":
                                //注册成功
                                JSONArray dataArray = obj.getJSONArray("data");
                                JSONObject userJson = dataArray.getJSONObject(0);
                                //解析当前对象
                                UserData user = UserData.getUserLoginData(userJson);
                                if(LoginUtil.saveUserLoginData(LoginActivity.this,user))
                                    msg.what = LOGIN_SUCCESS;//验证成功  结束当前Activity：
                                else
                                    msg.what = LOGIN_FAIL;//保存失败
                                break;
                            case "-1":
                                //登陆账号  不存在
                                msg.what = ACCOUNT_NO_EXIST;
                                break;
                            case "-2":
                                //登陆密码不正确
                                msg.what = PWD_IS_WRONG;
                                break;
                            case "-3":
                                //登陆账号  和密码不可为空
                                msg.what = ACCANDPWD_ISNOT_NULL;
                                break;
                            default:
                                break;
                        }

                    }else{
                        msg.what = LOGIN_FAIL;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }).execute(acc,pwd);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断   注册返回数据  是否成功
        switch (requestCode){
            case ACTIV_REGISTER:
                //注册界面  成功  返回数据

                break;
            default:break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
