package com.wm.mutildatasource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wangm
 * @date: 2021/7/28 14:47
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private int id;

    private String name;

    private int age;

    private String sex;
}
