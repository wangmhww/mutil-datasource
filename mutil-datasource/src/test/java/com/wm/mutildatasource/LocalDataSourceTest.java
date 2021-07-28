package com.wm.mutildatasource;

import com.wm.mutildatasource.mapper.local.UserMapper;
import com.wm.mutildatasource.model.User;
import com.wm.mutildatasource.service.local.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: wangm
 * @date: 2021/7/28 15:23
 * @Description
 */
@SpringBootTest
public class LocalDataSourceTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUser(){
        User user = new User("汪明", 26, "男");
        System.out.println(userService.insert(user));
    }
}
