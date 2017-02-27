package tianxing.app.callcall.customer.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;


/**
 * Package_name:com.yunduo.huopinclientapp.utils
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/11/24  23:48
 */
public final class ActionBarManager {

    private static ActionBarManager instance;
    /**
     * 单一实例
     */
    public static ActionBarManager getInstance() {
        if (instance == null) {
            instance = new ActionBarManager();
        }
        return instance;
    }

    public void initSystemBarTran(boolean on, Activity act,int color) {

        // 4.4及以上版本开启
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            Window win = act.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(act);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);

        // 自定义颜色
        tintManager.setTintColor(act.getResources().getColor(color));
    }
}
