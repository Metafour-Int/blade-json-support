package com.bladejava.fastjson;

import com.alibaba.fastjson.TypeReference;
import com.blade.kit.JsonKit;
import com.blade.kit.json.FastJsonSupport;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author biezhi
 * @date 2018/6/1
 */
public class FastjsonTest {

    @BeforeClass
    public static void beforeClass() {
        JsonKit.jsonSupprt(new FastJsonSupport());
    }

    @Test
    public void testToString() {
        Person person = Person.builder()
                .age(22)
                .bio("Hello World")
                .birthday(new Date())
                .money(2819D)
                .id(1002L)
                .price(new BigDecimal("23.81"))
                .build();

        System.out.println(JsonKit.toString(person));

        List<Person> people = Arrays.asList(person);
        System.out.println(JsonKit.toString(people));

        Map<String, Person> map = new HashMap<String, Person>();
        map.put("hello", person);
        System.out.println(JsonKit.toString(map));
    }

    @Test
    public void testFormJson() {
        String              json   = "{\"age\":22,\"bio\":\"Hello World\",\"birthday\":1527836202864,\"id\":1002,\"money\":2819.0,\"price\":23.81}";
        Person              person = JsonKit.formJson(json, Person.class);
        Map<String, Object> map    = JsonKit.formJson(json, new TypeReference<Map<String, Object>>() {}.getType());

        System.out.println(person);
        System.out.println(map);
        System.out.println(JsonKit.formJson(json, Map.class));

        json = "[{\"age\":22,\"bio\":\"Hello World\",\"birthday\":1527836237864,\"id\":1002,\"money\":2819.0,\"price\":23.81}]";
        List<Person> people = JsonKit.formJson(json, new TypeReference<List<Person>>() {}.getType());
        System.out.println(people);
        System.out.println(JsonKit.formJson(json, List.class));
    }

}
