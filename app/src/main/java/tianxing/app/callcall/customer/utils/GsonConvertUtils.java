package tianxing.app.callcall.customer.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Package_name:tianxing.app.callcall.customer.utils
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/05  23:18
 */
public class GsonConvertUtils {

    private static Gson create() {
        return GsonConvertUtils.GsonHolder.gson;
    }

    private static class GsonHolder {
        private static Gson gson = new Gson();
    }

    /**
     * 返回一个  T类型的  对象
     * @param json json字符串
     * @param type 字节码类型
     * @param <T> 泛型参数
     * @return 返回值 T
     * @throws JsonIOException 异常
     * @throws JsonSyntaxException 异常
     */
    public static <T> T fromJson(String json, Class<T> type) throws JsonIOException,
            JsonSyntaxException {
        return create().fromJson(json, type);
    }

    public static <T> T fromJson(String json, Type type) {
        return create().fromJson(json, type);
    }

    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(reader, typeOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return create().fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(json, typeOfT);
    }

    public static String toJson(Object src) {
        return create().toJson(src);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        return create().toJson(src, typeOfSrc);
    }

    /**
     * jsonString  转换成 一个List集合
     * @param jsonString json串
     * @param <T> 泛型
     * @return
     */
    public static <T> List<T> getObjs(String jsonString)
    {
        List<T> list = null;
        Gson gson = new Gson();
        list = gson.fromJson(jsonString, new TypeToken<List<T>>(){}.getType());
        return list;
    }

    /**
     * 泛型为  Map对象
     * @param jsonString  泛型参数
     * @return 返回值
     */
    public static List<Map<String,Object>> getListMap(String jsonString)
    {
        List<Map<String,Object>> list = null;
        Gson gson = new Gson();
        list = gson.fromJson(jsonString, new TypeToken<List<Map<String,Object>>>(){}.getType());
        return list;
    }

    /**
     * 返回一个对象
     * @param jsonString  json字符串
     * @param cls 参数类型
     * @param <T> 泛型T
     * @return 返回值
     */
    public static <T> T getObj(String jsonString,Class<T> cls)
    {
        T t = null;
        Gson gson = new Gson();
        t = gson.fromJson(jsonString, cls);
        return t;
    }
}
