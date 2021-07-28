package com.wm.mutildatasource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wangm
 * @date: 2021/7/28 14:41
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    public Product(String productName, Integer stock, Integer version) {
        this.productName = productName;
        this.stock = stock;
        this.version = version;
    }

    private Integer id;

    private String productName;

    private Integer stock;

    private Integer version;

}
