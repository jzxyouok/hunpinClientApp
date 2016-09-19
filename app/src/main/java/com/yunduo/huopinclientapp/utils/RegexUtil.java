package com.yunduo.huopinclientapp.utils;

import android.text.TextUtils;

/**
 * Package_name:com.yunduo.huopinclientapp.utils
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/18  15:34
 */
public final class RegexUtil {

    /**
     * 验证手机格式
     */
    public static boolean isMobileFormat(String phone) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
        // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "[1][34578]\\d{9}";
        if (TextUtils.isEmpty(phone))
            return false;
        else
            return phone.matches(telRegex);
    }

}
