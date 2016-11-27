package com.yunduo.huopinclientapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.yunduo.huopinclientapp.activitys.BaseActivity;
import com.yunduo.huopinclientapp.activitys.IndexActivity;
import com.yunduo.huopinclientapp.utils.SPUtils;

/**
 * 商户端
 */
public class StartActivity extends BaseActivity {

    private static int Enter_MainActivity = 1;//进入页面的标记值

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == Enter_MainActivity){
                ActManager.getActManager().openActivity(StartActivity.this, MainActivity.class, null);
                ActManager.getActivity(StartActivity.class).finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止第三方跳转时出现双实例
        Activity aty = ActManager.getActivity(MainActivity.class);
        if (aty != null && !aty.isFinishing()) {
            ActManager.getActivity(MainActivity.class).finish();
        }

        //如果是第一次进来，就显示引导页  并进入主界面
        if((Boolean) SPUtils.get_CFG(StartActivity.this, IndexActivity.FIRST_ENTER, true)){
            ActManager.getActManager().openActivity(StartActivity.this, IndexActivity.class, null);
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
