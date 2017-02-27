package tianxing.app.callcall.customer.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import tianxing.app.callcall.customer.utils.MyToastUtil;

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
