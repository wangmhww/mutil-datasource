package com.wm.mutildatasource.service.local.impl;

import com.wm.mutildatasource.mapper.local.UserMapper;
import com.wm.mutildatasource.model.User;
import com.wm.mutildatasource.service.local.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: wangm
 * @date: 2021/7/28 14:55
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
