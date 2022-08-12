package com.iweb.DAO;
import com.iweb.pojo.Product;

import java.util.List;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 9:50
 * @description 类的描述与介绍
 */
public interface ProductDAO {
    /**增
     * @param product 要添加的商品对象引用
     */
    void add(Product product);

    /**根据id删除商品
     * @param id 分类id
     */
    void delete(int id);

    /**修改商品数据
     * @param product
     */
    void update(Product product);

    /**根据id获取单个商品对象
     * @param id 根据id对应分类主键
     * @return 根据id获取的分类对象
     */
    Product get(int id);

    /**用来对商品信息进行分页查询
     * @param cid 查询的分页id
     * @param start 查询语句起始截止行数
     * @param count 查询语句起始截止行数
     * @return
     */
    List<Product> listByLimit(int cid,int start,int count);

    /**默认查询所有商品
     * @return 查询到的所有分类集合
     */
    List<Product> list();

    /**
     * 根据分类id获取指定的商品对象
     * @param cid 分类id
     * @return 指定分类下的商品集合
     */
    List<Product> list(int cid);

}
