package tianxing.app.callcall.customer.domain;

import java.util.ArrayList;

import tianxing.app.callcall.customer.domain.BaseEntity;
import tianxing.app.callcall.customer.domain.DataBean;

/**
 * Package_name:tianxing.app.callcall.customer.client
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/05  23:09
 */
public class OKDataResponse<T> extends BaseEntity {

    public String other;//消息

    public boolean isOk; //状态码

    public String resultMessage;  //提示信息

    public int resultCode;

    public T data;  //数据

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OKDataResponse{" +
                "other='" + other + '\'' +
                ", isOk=" + isOk +
                ", resultMessage='" + resultMessage + '\'' +
                ", resultCode=" + resultCode +
                ", data=" + data +
                '}';
    }
}
