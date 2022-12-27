package com.jyh.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {

    private static SerializerFeature[] features = null;

    static {
        features = new SerializerFeature[]{
                SerializerFeature.WriteMapNullValue,  // 值是null的属性也进行转换
                SerializerFeature.WriteNullStringAsEmpty, // 字符串的值为null时，转为""
                SerializerFeature.WriteNullListAsEmpty, //列表值为null时，转为[]
                SerializerFeature.WriteNullNumberAsZero,// 表示数值的对象为null时，转为0
                SerializerFeature.WriteDateUseDateFormat // 使用yyyy-MM-dd HH:mm:ss格式化日期对象
        };
    }

    /**
     * java对象转为json格式字符串
     *
     * @param obj
     * @return
     */
    public static String bean2json(Object obj) {
        return JSON.toJSONString(obj, features);
    }
}
