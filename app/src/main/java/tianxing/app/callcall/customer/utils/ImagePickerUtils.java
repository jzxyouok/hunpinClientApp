package tianxing.app.callcall.customer.utils;

import android.content.Context;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;

import tianxing.app.callcall.customer.R;

/**
 * Package_name:com.edu.fangqiu.gkww.utils
 * Author:zhaoqiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/27    20：09
 */

public final class ImagePickerUtils {

    private static ImagePickerUtils instance;

    private ImagePicker imagePicker;

    private ImagePickerUtils(){}

    public static ImagePickerUtils getImpickerUtils(){
        if (instance == null){
            instance = new ImagePickerUtils();
        }
        return instance;
    }

    /**
     * 初始化 IamgePicker:
     */
    public void initImagePicker(Context context) {
        imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new PicassoUtils());//设置 图片加载器
        imagePicker.setMultiMode(false);//设置为单选  图片

        imagePicker.setCrop(true);
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);

        //设置焦点 宽度和高度
        imagePicker.setFocusWidth(context.getResources().getDimensionPixelOffset(R.dimen.DIMEN_600PX));
        imagePicker.setFocusHeight(context.getResources().getDimensionPixelOffset(R.dimen.DIMEN_600PX));
        //设置输出  图片的大下和    焦点一样
        imagePicker.setOutPutY(context.getResources().getDimensionPixelOffset(R.dimen.DIMEN_600PX));
        imagePicker.setOutPutX(context.getResources().getDimensionPixelOffset(R.dimen.DIMEN_600PX));
        //设置 允许 选择的 项目
        imagePicker.setSelectLimit(1);
    }
}
