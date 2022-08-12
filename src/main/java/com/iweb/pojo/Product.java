package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 10:07
 * @description 类的描述与介绍
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private float price;
    private int stock;
    private int cid;
}
