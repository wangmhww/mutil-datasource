package com.wm.mutildatasource.service.aliyun.impl;

import com.wm.mutildatasource.mapper.aliyun.ProductMapper;
import com.wm.mutildatasource.model.Product;
import com.wm.mutildatasource.service.aliyun.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author: wangm
 * @date: 2021/7/28 15:01
 * @Description
 */
@Service
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }
}
