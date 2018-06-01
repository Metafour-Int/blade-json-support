package com.blade.kit.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;

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
        if (null != features) {
            return JSON.toJSONString(object, features);
        } else {
            return JSON.toJSONString(object);
        }
    }

    @Override
    public <T> T formJson(String json, Type cls) {
        return JSON.parseObject(json, cls);
    }

}
