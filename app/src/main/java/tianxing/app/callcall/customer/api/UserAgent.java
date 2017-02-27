package tianxing.app.callcall.customer.api;

import android.os.Build;

import tianxing.app.callcall.customer.AppAplication;

/**
 * Package_name:com.edu.fangqiu.gkww.client
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/13  15:55
 */

public final class UserAgent {

    /**
     * 获取  请求Agent
     */
    public static String getUserAgent(AppAplication appContext){
        StringBuilder sb = new StringBuilder("fangqiu.gkww");

        //版本信息
        sb.append('/' +appContext.getPackageInfo().versionName
            +"_" + appContext.getPackageInfo().versionCode);
        sb.append("/Android");//平台
        sb.append("/"+ Build.VERSION.RELEASE);//手机的  版本系统
        sb.append("/"+ Build.MODEL);//手机型号

        sb.append("/"+appContext.getAppId());

        return sb.toString();
    }


}
