package com.wm.mutildatasource;

import com.wm.mutildatasource.model.Product;
import com.wm.mutildatasource.service.aliyun.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: wangm
 * @date: 2021/7/28 15:11
 * @Description
 */
@SpringBootTest
public class AliyunDataSourceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void insertProduct(){
        Product product = new Product("金融云产品开发", 100, 322);

        int insert = productService.insert(product);
        System.out.println(insert);

    }
}
