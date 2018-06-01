package com.bladejava.fastjson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author biezhi
 * @date 2018/6/1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long       id;
    private Integer    age;
    private BigDecimal price;
    private Double     money;
    private Date       birthday;
    private String     bio;

}
