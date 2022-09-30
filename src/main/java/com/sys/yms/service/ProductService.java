package com.sys.yms.service;

import com.sys.yms.entity.Product;

import java.util.List;

public interface ProductService {
    //查询产品
    List<Product> getProduct(Integer page,Integer limit,String productName,String productType,Double price_min,Double price_max);
    //获取产品数量
    Integer getProductCount(String productName,String productType,Double price_min,Double price_max);
    //添加产品
    Integer addProduct(String ProductName,Double price,Double discount ,String description,Integer typeId,String imageUrl);
    //根据id修改状态
    Integer updateProductState(Integer id,Integer productState);
    //根据id修改热饮状态
    Integer updateProductHotState(Integer id,Integer productHotState);
    //根据id删除商品
    Integer delProduct(Integer id);
    //修改商品
    Integer updateProduct(String ProductName,String description,Double discount,Double price, Integer productId,Integer typeId,String imageUrl);
}
