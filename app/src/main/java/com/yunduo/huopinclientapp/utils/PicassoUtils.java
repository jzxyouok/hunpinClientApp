package com.yunduo.huopinclientapp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lzy.imagepicker.loader.ImageLoader;
import com.squareup.picasso.Picasso;
import com.yunduo.huopinclientapp.R;

import java.io.File;

/**
 * Package_name:com.edu.fangqiu.gkww.utils
 * Author:zhaoqiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/21    12.
 */

public final class PicassoUtils implements ImageLoader {


    private static PicassoUtils instance;

    /**
     * 获取当前对象
     * @return
     */
    public static PicassoUtils getInstance(){
        if(instance == null){
            instance = new PicassoUtils();
        }
        return instance;
    }

    //全局  公用的  Picasso设置图片类   在此   对图片  进行裁剪    和对 大图片的  内存优化
    public static void  setImageUrl(Context context, String url, ImageView imageView,
                                    int width, int height){

        //使用   本地图标路径   最好
        if(url.isEmpty()){
            //默认显示  公司图标
            imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.default_image));
        }else{
            Picasso.with(context).load(url)
                    .placeholder(R.mipmap.default_image)//
                    .error(R.mipmap.default_image)//
                    .config(Bitmap.Config.RGB_565)  //不透明图片  使用RGB_565  增加内存优化率
                    .resize(width,
                            height)//
//              .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .centerInside()//
                    .into(imageView);
        }
    }

    /**
     * 用于显示  打开相机后的  列表图片
     * @param activity
     * @param path
     * @param imageView
     * @param width
     * @param height
     */
    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {

        if(!path.isEmpty()){
            Picasso.with(activity)
                    .load(new File(path))
                    .placeholder(R.mipmap.default_image)//
                    .error(R.mipmap.default_image)//
                    .resize(width,
                            height)//
//              .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .centerInside()
                    //添加  回调  当网络获取头像失败时  使用 本地查找  缓存的办法加载图片
                    .into(imageView);
        }
//            暂时 不使用glide
//        Glide.with(activity)                             //配置上下文
//                .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//                .error(R.mipmap.default_image)           //设置错误图片
//                .placeholder(R.mipmap.default_image)//设置占位图片
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
//                .into(imageView);

    }

    /**
     * 是否  清除 缓存
     */
    @Override
    public void clearMemoryCache() {

    }
}
