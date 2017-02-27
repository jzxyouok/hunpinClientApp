package tianxing.app.callcall.customer.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import tianxing.app.callcall.customer.R;

/**
 * Package_name:com.yunduo.huopinclientapp.dialog
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/10/9  14:56
 * 对话框  帮助类
 */
public final class DialogUtil {

    /***
     * 获取一个dialog
     * @param context
     * @return
     */
    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.SelectDialogStyle);
        return builder;
    }

    public static AlertDialog.Builder getSelectDialog(Context context, String title, View.OnClickListener itemClickListener) {
        AlertDialog.Builder builder = getDialog(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_select_headic, null);
        TextView album = (TextView) view.findViewById(R.id.album);
        TextView camera = (TextView) view.findViewById(R.id.camera);

        album.setOnClickListener(itemClickListener);
        camera.setOnClickListener(itemClickListener);

        builder.setView(view);

        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        return builder;
    }

    //推出登陆程序
    public static AlertDialog.Builder getExitDialog(final Context context, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if(title!=null){
            builder.setTitle(title);
        }
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //清除缓存  推出登陆
                SPUtils.clear(context,SPUtils.FILE_NAME_LOGIN_USER_INFO);
                MyToastUtil.ToastInLow(context,"当前已退出");
            }
        });

        builder.setNegativeButton("取消",null);
        return builder;
    }
}
