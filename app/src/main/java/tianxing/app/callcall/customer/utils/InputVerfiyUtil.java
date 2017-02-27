package tianxing.app.callcall.customer.utils;

import android.content.Context;

/**
 * Package_name:com.yunduo.huopinclientapp.utils
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/19  17:17
 * 校验   输入数据类
 */
public final class InputVerfiyUtil {

    //检验输入  电话号码：
    public static boolean verfiyPhoneNum(Context context, String phone){
        if (phone==null||phone.equals("")) {//判断不为空
            MyToastUtil.ToastIncenter(context,"手机号不能为空");
            return false;
        }
        if (phone.length() != 11) {
            MyToastUtil.ToastIncenter(context,"请输入11位手机号");
            return false;
        }
        if (!RegexUtil.isMobileFormat(phone)) {
            MyToastUtil.ToastIncenter(context,"手机号格式不正确");
            return false;
        }
        return true;
    }

    //检验  输入pwd
    public static boolean verfiyPwd(Context context,String pwd){
        if (pwd==null||pwd.equals("")) {//
            MyToastUtil.ToastIncenter(context,"密码不能空");
            return false;
        }
        if (pwd.length()<6){
            MyToastUtil.ToastIncenter(context,"密码不能小于6位");
            return false;
        }
        return true;
    }

    /**
     * 教研  输入  验证码
     */
    public static boolean verfiyPhoneCode(Context context,String phoneCode) {
        if (phoneCode==null||phoneCode.equals("")) {
            MyToastUtil.ToastIncenter(context,"请输入验证码");
            return false;
        }
        return true;
    }


    //判断  密码 验证密码  是否相等
    public static boolean isEquals(Context context,String pwd, String repwd) {
        if(pwd.equals(repwd)){
            return true;
        }
        MyToastUtil.ToastIncenter(context,"输入密码和验证密码不相等！");
        return false;
    }
}
