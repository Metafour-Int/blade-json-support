package com.blade.kit.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Jackson Support
 *
 * @author biezhi
 * @date 2017/12/15
 */
@Slf4j
public class JacksonSupport implements JsonSupport {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

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
    public <T> T formJson(String value, Type type) {
        T object = null;
        try {
            object = (T) OBJECT_MAPPER.readValue(value, (Class) type);
        } catch (IOException e) {
            log.error("Jackson readValue fail", e);
        }
        return object;
    }
}
