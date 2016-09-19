package com.yunduo.huopinclientapp.activitys;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.configs.URLS;
import com.yunduo.huopinclientapp.utils.InputVerfiyUtil;
import com.yunduo.huopinclientapp.utils.MyToast;
import com.yunduo.huopinclientapp.utils.NetWorkListener;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * 注册界面
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private EditText regPhone,regPwd,regPhoneCode;
    private Button btnGetCode,btnReg;

    private static final int FINISH_ACTIVITY = 1;//结束当前 Activity
    private static final int VERFIY_COMPLETEED = 2; //验证完成
    private static final int VERFIY_FAIL = 3;//验证失败

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case FINISH_ACTIVITY:
                    RegisterActivity.this.finish();
                    break;
                case VERFIY_COMPLETEED:
                    MyToast.ToastIncenter(RegisterActivity.this,"开始验证");
                    break;
                case VERFIY_FAIL:
                    MyToast.ToastIncenter(RegisterActivity.this,"验证失败");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化短信验证
        SMSSDK.registerEventHandler(ev); //注册短信回调监听

        initView();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.reg_title_back);
        regPhone = (EditText) findViewById(R.id.et_reg_number);
        regPwd = (EditText) findViewById(R.id.et_reg_pwd);
        regPhoneCode = (EditText) findViewById(R.id.et_authreg_code);

        btnGetCode = (Button) findViewById(R.id.bt_getregauth_pwd);
        btnReg = (Button) findViewById(R.id.btn_finish_reg);

        back.setOnClickListener(this);
        btnGetCode.setOnClickListener(this);
        btnReg.setOnClickListener(this);
    }

    private String acc;
    private String pwd;
    private String phoneCode;

    @Override
    public void onClick(View view) {

        acc = regPhone.getText().toString().trim();
        pwd = regPwd.getText().toString().trim();
        phoneCode = regPhoneCode.getText().toString();

        //注册界面
        switch(view.getId()){

            case R.id.reg_title_back:
                //返回  上一级
                finish();
                break;

            case R.id.bt_getregauth_pwd:
                if(InputVerfiyUtil.verfiyPhoneNum(this,acc)){
                    //获取 验证码
                    SMSSDK.getVerificationCode("+86", acc);
                }
                break;

            case R.id.btn_finish_reg:
                //校验输入数据：
                if(InputVerfiyUtil.verfiyPhoneNum(this,acc)&&InputVerfiyUtil.verfiyPwd(this,pwd)
                    &&InputVerfiyUtil.verfiyPhoneCode(this,phoneCode)){
                    //验证验证码
//                    SMSSDK.submitVerificationCode("+86", acc, phoneCode);//国家号，手机号码，验证码
                    register(acc,pwd);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 短信验证的回调监听
     */
    private  EventHandler ev = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {
            if (result == SMSSDK.RESULT_COMPLETE) { //回调完成
                Message msg = new Message();
                //提交  验证码成功,如果  验证成功会在data里返回数据。data数据类型为HashMap<number,code>
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //验证 验证码回调  验证输入验证码
                    HashMap<String, Object> mData = (HashMap<String, Object>) data;
                    String country = (String) mData.get("country");//返回的国家编号
                    String phone = (String) mData.get("phone");//返回用户注册的手机号

                    if(phone.equals(acc)){
                        //验证成功 z注册信息

                    }else{
                        //验证失败
                        msg.what = VERFIY_FAIL;//验证失败：
                    }
                }else if(event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                    msg.what = VERFIY_COMPLETEED;//短信发送成功   暂不处理
                }
                handler.sendMessage(msg);
            }else {
                Message msg = new Message();
                msg.what = VERFIY_FAIL;//验证失败：
                handler.sendMessage(msg);
                ((Throwable)data).printStackTrace();
            }
        }
    };

    //开始注册
    private void register(String acc, String pwd) {
        //服务端注册信息


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //要在activity销毁时反注册，否侧会造成内存泄漏问题
        SMSSDK.unregisterAllEventHandler();
    }

}