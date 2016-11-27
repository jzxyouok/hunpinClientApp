package com.yunduo.huopinclientapp.fragments;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.activitys.LoginActivity;
import com.yunduo.huopinclientapp.activitys.SettingActivity;
import com.yunduo.huopinclientapp.utils.DialogUtil;
import com.yunduo.huopinclientapp.utils.FileUtils;
import com.yunduo.huopinclientapp.utils.ImageUtils;
import com.yunduo.huopinclientapp.utils.LoginUtil;
import com.yunduo.huopinclientapp.utils.MyToast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 我的
 */
public class MyFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView titleTxt;
    private ImageView imgIc,icSet;

    private TextView btnRegOrlog;

    private ImageView headIcon;

    private final static String FILE_SAVEPATH = Environment
            .getExternalStorageDirectory().getAbsolutePath()
            + "/huoPin/Portrait/"; //头像保存路径

    public MyFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);
        initView();
        return view;
    }

    public void initView() {
        titleTxt = (TextView) view.findViewById(R.id.title_bar_text);
        titleTxt.setText(R.string.title_wode);
        imgIc = (ImageView) view.findViewById(R.id.my_ic_setting);
        imgIc.setVisibility(View.VISIBLE);
        icSet = (ImageView) view.findViewById(R.id.my_ic_setting);

        headIcon = (ImageView) view.findViewById(R.id.my_head_img);
        headIcon.setOnClickListener(this);

        btnRegOrlog = (TextView) view.findViewById(R.id.my_btn_reg);

        btnRegOrlog.setOnClickListener(this);
        icSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.my_head_img:
                //弹出对话框  更改头像：
                if(true){//TODO 判断  当前是否登录
                    handleSelectPicture();  //选择照片  或者  照相机
                }else{
                    MyToast.ToastInLow(getActivity(),getString(R.string.had_no_login));
                }
                break;
            case R.id.my_btn_reg:
                //判断  当前  是否已经登录
                if(!LoginUtil.isLogin(getContext())){
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }else{
                    MyToast.ToastInLow(getActivity(),getString(R.string.had_login));
                }
                break;

            case R.id.my_ic_setting:
                //进入设置界面
                startActivity(new Intent(getActivity(),SettingActivity.class));
                break;

            default:break;
        }
    }


    private void handleSelectPicture() {
        DialogUtil.getSelectDialog(getContext(), null, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    //打卡本地 相册
                    case R.id.album:
                        startImagePick();
                        break;
                    //打开照相机
                    case R.id.camera:
//                        startTakePhotoByPermissions();
                        break;

                    default:break;
                }
            }
        }).show();
    }

    /**
     * 选择图片裁剪   打开本地相册  进行图片裁剪
     */
    private void startImagePick() {
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"),
                    ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP);
        } else {
            intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"),
                    ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP);
        }
    }

    private Uri origUri;

    private void startTakePhoto() {
        Intent intent;
        // 判断是否挂载了SD卡
        String savePath = "";
        String storageState = Environment.getExternalStorageState();
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
            savePath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/huopin/Camera/";
            File savedir = new File(savePath);
            if (!savedir.exists()) {
                savedir.mkdirs();
            }
        }

        // 没有挂载SD卡，无法保存文件
        if (savePath!="" && !savePath.equals("")) {
            MyToast.ToastInLow(getContext().getApplicationContext(),"无法保存照片，请检查SD卡是否挂载");
            return;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
        String fileName = "headIc_" + timeStamp + ".jpg";// 照片命名
        File out = new File(savePath, fileName);
        Uri uri = Uri.fromFile(out);
        origUri = uri;

        String theLarge = savePath + fileName;

        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent,
                ImageUtils.REQUEST_CODE_GETIMAGE_BYCAMERA);
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode,
                                 final Intent imageReturnIntent) {
        if (resultCode != Activity.RESULT_OK)
            return;

        switch (requestCode) {

            case ImageUtils.REQUEST_CODE_GETIMAGE_BYCAMERA:
//                startActionCrop(origUri);// 拍照后裁剪
                break;

            case ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP:
                Log.i("info","-----caijian---");
                startActionCrop(imageReturnIntent.getData());// 选图后裁剪
                break;

            case ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD: //裁剪  完成上传至服务器
                Log.i("info","---che----------------------------------------------nggong-");
//                uploadNewPhoto();
                break;
        }
    }



//    /**
//     * 保存裁剪之后的图片数据
//     * @param picdata
//     */
//    private void setPicToView(Intent picdata) {
//        Bundle extras = picdata.getExtras();
//        if (extras != null) {
//
//            Log.i("info",extras.toString()+"--");
//            // 取得SDCard图片路径做显示
//            Bitmap photo = extras.getParcelable("data");
//            Drawable drawable = new BitmapDrawable(null, photo);
//            //保存文件到本地
//            FileUtils.saveFile(getContext(),"", "headic",
//                    FileUtils.bitmapToBytes(photo));
//            headIcon.setImageDrawable(drawable);
//
//            // 新线程后台上传服务端
////            pd = ProgressDialog.show(mContext, null, "正在上传图片，请稍候...");
////            new Thread(uploadImageRunnable).start();
//        }
//    }

    /**
     * 拍照后裁剪
     * @param data 原始图片
     */
    private void startActionCrop(Uri data) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(data, "image/*");
        intent.putExtra("output", this.getUploadTempFile(data));
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);// 裁剪框比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", R.dimen.DIMEN_100PX);// 输出图片大小
        intent.putExtra("outputY", R.dimen.DIMEN_100PX);
        intent.putExtra("scale", true);// 去黑边
        intent.putExtra("scaleUpIfNeeded", true);// 去黑边

        startActivityForResult(intent,
                ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD);
    }

    private String protraitPath;
    private File protraitFile;
    // 裁剪头像的绝对路径
    private Uri getUploadTempFile(Uri uri) {
        String storageState = Environment.getExternalStorageState();
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
            File savedir = new File(FILE_SAVEPATH);
            if (!savedir.exists()) {
                savedir.mkdirs();
            }
        } else {
            MyToast.ToastIncenter(getContext(),"无法保存上传的头像，请检查SD卡是否挂载");
            return null;
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String thePath = ImageUtils.getAbsolutePathFromNoStandardUri(uri);

        // 如果是标准Uri
        if (thePath==null || thePath.equals("")) {
            thePath = ImageUtils.getAbsoluteImagePath(getActivity(), uri);
        }
        String ext = FileUtils.getFileFormat(thePath);
        ext = (ext == null || ext.equals(""))? "jpg" : ext;
        // 照片命名
        String cropFileName = "huopin_crop_" + timeStamp + "." + ext;
        // 裁剪头像的绝对路径
        protraitPath = FILE_SAVEPATH + cropFileName;
        protraitFile = new File(protraitPath);

        return Uri.fromFile(protraitFile);
    }

}
