package com.yunduo.huopinclientapp.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.yunduo.huopinclientapp.ActManager;
import com.yunduo.huopinclientapp.R;

/**
 * 注册界面
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;

    private EditText regPhone,regPwd,regPhoneCode;

    private Button btnGetCode,btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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


    @Override
    public void onClick(View view) {
        //注册界面
        switch(view.getId()){

            case R.id.reg_title_back:
                //返回  上一级
                finish();
                break;

            case R.id.bt_getregauth_pwd:
                //获取验证手机号
                break;

            case R.id.btn_finish_reg:
                //开始注册
                break;

            default:
                break;
        }
    }
}
