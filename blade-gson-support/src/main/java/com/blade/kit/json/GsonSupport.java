package com.blade.kit.json;

import com.google.gson.Gson;

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
    public <T> T formJson(String value, Class<T> cls) {
        return gson.fromJson(value, cls);
    }

}
