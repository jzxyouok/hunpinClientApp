package tianxing.app.callcall.customer.client;

/**
 * Package_name:com.edu.fangqiu.gkww.client
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2016/12/13  14:57
 * 封装 所有对的   URL
 */

public final class URLs {

    public final static String HTTP = "http://";

    public static final String SERVER_IP = "120.76.240.166/CallCallStore";

    //发送验证码
    public static final String URL_SENDVERFIY = HTTP + SERVER_IP   +
             "/SingleSendSms";
    //登录
    public static final String URL_LOGIN = HTTP + SERVER_IP   +
             "/app_loginCustomerAction";
    //注册
    public static final String URL_REGISTER =  HTTP + SERVER_IP   +
             "/app_registerCustomerAction";


    //首页 GridView  数据
    public static final String FRIST_GRIDV_DATA_URL=  HTTP + SERVER_IP   +
             "/api/customer/shophome/appGetCatelogListAction.do";

}