package tianxing.app.callcall.customer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import tianxing.app.callcall.customer.activitys.BaseActivity;
import tianxing.app.callcall.customer.activitys.IndexActivity;
import tianxing.app.callcall.customer.utils.SPUtils;

/**
 * 商户端
 */
public class StartActivity extends BaseActivity {

    private static int Enter_MainActivity = 1;//进入页面的标记值

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == Enter_MainActivity){
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //如果是第一次进来，就显示引导页  并进入主界面
        if((Boolean) SPUtils.get_CFG(StartActivity.this, IndexActivity.FIRST_ENTER, true)){
            startActivity(new Intent(StartActivity.this,IndexActivity.class));
            finish();
            return;
        }

        //设置全屏显示
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //直接 进入主界面
        setContentView(R.layout.activity_start);

        //发送延时消息
        handler.sendEmptyMessageDelayed(Enter_MainActivity,2000);
    }
}
