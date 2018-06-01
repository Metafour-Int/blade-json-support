package com.blade.kit.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Gson Support
 *
 * @author biezhi
 * @date 2017/12/15
 */
public class GsonSupport implements JsonSupport {

    private Gson gson = new Gson();

    public GsonSupport() {
    }

    @Override
    public String toString(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T formJson(String value, Type type) {
        return gson.fromJson(value, type);
    }

}
