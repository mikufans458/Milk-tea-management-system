package com.sys.yms.service.impl;

import com.sys.yms.entity.Product;
import com.sys.yms.mapper.ProductMapper;
import com.sys.yms.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;
    @Override
    public List<Product> getProduct(Integer page, Integer limit,String productName,String productType,Double price_min,Double price_max) {
        Integer startIndex=(page-1)*limit;
        return productMapper.queryByPage(startIndex,limit,productName,productType,price_min,price_max);
    }

    @Override
    public Integer getProductCount(String productName,String productType,Double price_min,Double price_max) {
        return productMapper.productCount(productName,productType,price_min,price_max);
    }

    @Override
    public Integer addProduct(String ProductName, Double price, Double discount, String description, Integer typeId,String imageUrl) {
        Product product = new Product();
        product.setPname(ProductName);
        product.setTprice(price);
        product.setPdiscount(discount);
        product.setTintroduce(description);
        product.setTypeid(typeId);
        product.setPimageurl(imageUrl);
        return productMapper.insertProduct(product);
    }

    @Override
    public Integer updateProductState(Integer id, Integer productState) {
        return productMapper.updateProductStateById(id,productState);
    }

    @Override
    public Integer updateProductHotState(Integer id, Integer productHotState) {
        return productMapper.updateProductHotStateById(id,productHotState);
    }

    @Override
    public Integer delProduct(Integer id) {
        return productMapper.deleteById(id);
    }

    @Override
    public Integer updateProduct(String ProductName, String description, Double discount, Double price, Integer productId, Integer typeId,String imageUrl) {
        Product product = new Product();
        product.setPname(ProductName);
        product.setTintroduce(description);
        product.setPdiscount(discount);
        product.setTprice(price);
        product.setId(productId);
        product.setTypeid(typeId);
        product.setPimageurl(imageUrl);
        return productMapper.updateProduct(product);
    }
}
