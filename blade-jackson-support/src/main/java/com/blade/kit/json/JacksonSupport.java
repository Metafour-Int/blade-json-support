package com.blade.kit.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Jackson Support
 *
 * @author biezhi
 * @date 2017/12/15
 */
@Slf4j
public class JacksonSupport implements JsonSupport {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public String toString(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Jackson writeValueAsString fail", e);
        }
        return null;
    }

    @Override
    public <T> T formJson(String value, Class<T> cls) {
        T object = null;
        try {
            object = OBJECT_MAPPER.readValue(value, cls);
        } catch (IOException e) {
            log.error("Jackson readValue fail", e);
        }
        return object;
    }
}
