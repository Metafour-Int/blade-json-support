package com.blade.kit.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * Fastjson Support
 *
 * @author biezhi
 * @date 2017/12/15
 */
public class FastJsonSupport implements JsonSupport {

    private SerializerFeature[] features;

    public FastJsonSupport() {
    }

    public FastJsonSupport(SerializerFeature[] features) {
        this.features = features;
    }

    @Override
    public String toString(Object object) {
        return JSON.toJSONString(object, features);
    }

    @Override
    public <T> T formJson(String value, Class<T> cls) {
        return JSON.parseObject(value, cls);
    }

    public <T> List<T> parseArray(String value, Class<T> cls) {
        return JSON.parseArray(value, cls);
    }

    public <T> T parseObject(String value, TypeReference<T> typeReference) {
        return JSON.parseObject(value, typeReference);
    }

}
