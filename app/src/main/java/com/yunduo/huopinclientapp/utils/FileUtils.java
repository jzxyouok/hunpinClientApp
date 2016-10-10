package com.yunduo.huopinclientapp.utils;

/**
 * Package_name:com.yunduo.huopinclientapp.utils
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/10/9  16:30
 */
public final class FileUtils {

    /**
     * 获取文件扩展名
     * @param fileName
     * @return
     */
    public static String getFileFormat(String fileName) {
        if (fileName==" " || fileName.equals(""))
            return "";

        int point = fileName.lastIndexOf('.');
        return fileName.substring(point + 1);
    }


}
