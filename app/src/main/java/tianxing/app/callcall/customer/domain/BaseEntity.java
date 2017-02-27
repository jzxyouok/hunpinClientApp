package tianxing.app.callcall.customer.domain;

import java.io.Serializable;

/**
 * Package_name:com.yunduo.huopinclientapp.domain
 * Author:zhaoQiang
 * Email:zhao_hero@163.com
 * Date:2016/9/22  13:53
 * 所有  实体类的发 父类
 *
 * 实现 序列化接口  方便数据内存的  读取和存储
 */
public class BaseEntity implements Serializable {

    private String _id;//id标识

    public BaseEntity(){
        super();
    }

}
