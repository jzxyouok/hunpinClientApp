package tianxing.app.callcall.customer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Package_name:com.edu.fangqiu.gkww.utils
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/08  13:41
 * 共享参数  工具类     操作  共享参数工具类
 */
public final class SharePreferanceUtil {

    /**
     * 共享参数  文件名
     */
    private static final String FIlE_NAME = "gkww_sp";

    private static SharePreferanceUtil spUtil;

    public static SharePreferanceUtil getSpUtil(){
        if(spUtil == null){
            spUtil = new SharePreferanceUtil();
        }
        return  spUtil;
    }

    /**
     * 私有方法
     * @param context
     * @return
     */
    private SharedPreferences.Editor getSpEditor(Context context){
        SharedPreferences sp = context.getSharedPreferences(FIlE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        return editor;
    }

    /**
     * 移除  指定的键
     * @param context
     * @param key
     */
    public void remove_sp(Context context, String key){
        SharedPreferencesCompat.apply(getSpEditor(context).remove(key));
    }


    public void clear_sp(Context context){
        SharedPreferencesCompat.apply(getSpEditor(context).clear());
    }


    /**
     * 保存  参数
     * @param context  上下文
     * @param key  键
     * @param object  值
     */
    public void put_sp (Context context, String key, Object object){
        put_sp(context,FIlE_NAME,key,object);
    }

    /**
     * 保存  参数
     * @param context  上下文
     * @param key  键
     * @param object  值
     */
    public Object get_sp (Context context, String key, Object object){
        Object obj = get_sp(context,FIlE_NAME,key,object);

        if(obj!=null){
            return obj;
        }

        return null;
    }

    /**
     * 判断 是否包含    某个键
     * @param context
     * @param key
     * @return
     */
    public boolean contains_sp(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(FIlE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    //重载
    public Object get_sp(Context context, String fileName, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

        //重载
    private static void put_sp(Context context, String fIlE_name, String key, Object object) {

        SharedPreferences sp = context.getSharedPreferences(fIlE_name, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, (String)object);
        }
//        editor.apply();
//        editor.commit();
        SharedPreferencesCompat.apply(editor);
    }


    /***
     * 创建一个  解决 SharePreferancesCompat.app方法的  兼容类
     */
    private static class SharedPreferencesCompat{

        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射  查找  Apply的方法
         * @return
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;

                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * 使用  apply 方法
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor){
            try {
                if(sApplyMethod != null){
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (editor!=null){
                editor.commit();
            }
        }
    }
}
