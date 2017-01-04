package com.yunduo.huopinclientapp.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.yunduo.huopinclientapp.ActManager;
import com.yunduo.huopinclientapp.utils.MyToastUtil;

/**
 * Package_name:com.yunduo.huopinmerchantapp.activitys
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/13  0:23
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActManager.getActManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActManager.getActManager().finishActivity(this);
    }

    //间隔时间
    private static long exectTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK &&
                event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exectTime)>2000){//第一次点击
                MyToastUtil.ToastInLow(this,"再次点击退出程序");
                exectTime = System.currentTimeMillis();
            }else{
                finish();
                ActManager.getActManager().AppExit();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
