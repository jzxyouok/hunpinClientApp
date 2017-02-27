package tianxing.app.callcall.customer.activitys;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import tianxing.app.callcall.customer.api.ClientApi;
import tianxing.app.callcall.customer.utils.LoginUtil;
import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.utils.ActionBarManager;
import tianxing.app.callcall.customer.utils.MyToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 注册界面
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private EditText regPhone,regPwd,regPhoneCode,regRePwd;
    private Button btnGetCode,btnReg;

    private static final int REGISTER_SUCCESS = 3;//注册成功
    private static final int ACCOUNT_REGISTERED = 4;//账号已经被注册
    private static final int SERVICE_EXCEPTION = 5;//服务器异常
    private static final int ACC_NOTFORMAT = 6;//账号密码  格式不正确

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case REGISTER_SUCCESS:
                    MyToastUtil.ToastIncenter(RegisterActivity.this,"注册成功");
                    RegisterActivity.this.finish();
                    break;
                case ACCOUNT_REGISTERED:
                    MyToastUtil.ToastIncenter(RegisterActivity.this,"该账号已经被注册");
                    break;
                case SERVICE_EXCEPTION:
                    MyToastUtil.ToastIncenter(RegisterActivity.this,"服务器异常");
                    break;
                case ACC_NOTFORMAT:
                    MyToastUtil.ToastIncenter(RegisterActivity.this,"请注意输入数据格式");
                    break;


                case ClientApi.SEND_VERFIY_SUCCESS:
                    try {
                        String str = (String) msg.obj;
                        JSONObject object = new JSONObject(str);
                        MyToastUtil.ToastInLow(RegisterActivity.this,object.getString("resultMessage"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.i("info","json解析异常");
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_viphuopin);
        ActionBarManager.getInstance().initSystemBarTran(true,this,R.color.register_actionbar_color);
        initView();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.reg_title_back);
        regPhone = (EditText) findViewById(R.id.et_reg_number);
        regPwd = (EditText) findViewById(R.id.et_reg_pwd);
        regPhoneCode = (EditText) findViewById(R.id.et_authreg_code);
        regRePwd = (EditText) findViewById(R.id.et_reg_repwd);

        btnGetCode = (Button) findViewById(R.id.bt_getregauth_pwd);
        btnReg = (Button) findViewById(R.id.btn_finish_reg);

        back.setOnClickListener(this);
        btnGetCode.setOnClickListener(this);
        btnReg.setOnClickListener(this);
    }

    private String acc;
    private String pwd;
    private String phoneCode;
    private String repwd;

    @Override
    public void onClick(View view) {

        acc = regPhone.getText().toString().trim();
        pwd = regPwd.getText().toString().trim();
        phoneCode = regPhoneCode.getText().toString();
        repwd = regRePwd.getText().toString().trim();

        //注册界面
        switch(view.getId()){

            case R.id.reg_title_back:
                //返回  上一级
                finish();
                break;

            case R.id.bt_getregauth_pwd:
                //TODO  暂时不做验证
//                if(InputVerfiyUtil.verfiyPhoneNum(this,acc)){
                    //获取 验证码
                    LoginUtil.sendVerfiy(this,"18310541176",handler);
//                }
                break;

            case R.id.btn_finish_reg:
                //校验输入数据：
                //TODO  注册  暂时不做校验
//                if(InputVerfiyUtil.verfiyPhoneNum(this,acc) && InputVerfiyUtil.verfiyPwd(this,pwd)
//                    && InputVerfiyUtil.verfiyPhoneCode(this,phoneCode) && InputVerfiyUtil.isEquals(this,pwd,repwd)){
                    register("18310541176","123456",phoneCode); //测试进度条
//                }
                break;
            default:
                break;
        }
    }

    //开始注册
    private void register(String acc, String pwd,String phoneCode) {
        LoginUtil.toLogin(this,"18310541176","123456","167741",handler,"register");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
