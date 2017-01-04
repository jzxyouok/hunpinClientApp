package com.yunduo.huopinclientapp.utils;

/**
 * Package_name:com.edu.fangqiu.gkww.utils
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/13  16:07
 *
 * 对所有的  字符串操作的 类   判空 或者 判断类型等方法
 */

public final class StringUtils {

    /**
     * 判断 所传入的  数据是否为null 或者 有null串或者 其他特殊字符者
     * @return
     */
    public static boolean isEmpty(String inputText){
        if(inputText == null || "".equals(inputText)){
            return true;
        }

        for (int i = 0; i < inputText.length();i++){
            char c =  inputText.charAt(i);
            if(c != ' ' && c!='\t' && c != '\r' && c!='\n' ){
                return false;
            }
        }
        return true;
    }



}
