package com.wm.mutildatasource.mapper.local;

import com.wm.mutildatasource.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: wangm
 * @date: 2021/7/28 14:47
 * @Description
 */
@Mapper
public interface UserMapper {
    int insert(User user);
}
