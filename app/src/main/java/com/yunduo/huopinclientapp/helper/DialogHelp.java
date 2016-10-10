package com.yunduo.huopinclientapp.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yunduo.huopinclientapp.R;

import java.util.ArrayList;

/**
 * Package_name:com.yunduo.huopinclientapp.dialog
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/10/9  14:56
 * 对话框  帮助类
 */
public final class DialogHelp {

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

}
