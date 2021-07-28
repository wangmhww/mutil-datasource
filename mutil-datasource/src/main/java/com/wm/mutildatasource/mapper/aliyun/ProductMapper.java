package com.wm.mutildatasource.mapper.aliyun;

import com.wm.mutildatasource.model.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: wangm
 * @date: 2021/7/28 14:39
 * @Description
 */
@Mapper
public interface ProductMapper {
    int insert(Product product);

}
