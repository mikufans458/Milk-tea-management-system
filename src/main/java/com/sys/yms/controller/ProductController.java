package com.sys.yms.controller;

import com.sys.yms.entity.Product;
import com.sys.yms.service.ProductService;
import com.sys.yms.util.ResponseCode;
import com.sys.yms.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;
    @RequestMapping("/getProduct")
    @ResponseBody
    //分页查询所有的产品
    public ResponseData getProductByPage(Integer page,Integer limit,String productName,String productType,Double price_min,Double price_max)
    {
        List<Product> product = productService.getProduct(page, limit,productName,productType,price_min,price_max);
        Integer count= productService.getProductCount(productName,productType,price_min,price_max);
        return new ResponseData(ResponseCode.SUCCESS,product,count);
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    //添加产品
    public ResponseData addProduct(String ProductName,Double price,Double discount ,String description,Integer typeId,String imageUrl)
    {
        Integer rows = productService.addProduct(ProductName, price, discount, description,typeId,imageUrl);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_3);
        }
    }

    //修改产品状态
    @RequestMapping("/updateProductState")
    @ResponseBody
    public ResponseData updateProductState(Integer id,Integer productState)
    {
        Integer rows=productService.updateProductState(id,productState);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_3);
        }
    }

    //修改产品热饮状态
    @RequestMapping("/updateProductHotState")
    @ResponseBody
    public ResponseData updateProductHotState(Integer id,Integer productHotState)
    {
        Integer rows=productService.updateProductHotState(id,productHotState);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_3);
        }
    }

    //删除产品
    @RequestMapping("/delProduct")
    @ResponseBody
    public ResponseData delProductById(Integer id)
    {
        Integer rows= productService.delProduct(id);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_4);
        }
    }

    //修改产品
    @RequestMapping("/updateProduct")
    @ResponseBody
    public ResponseData updateProduct(String ProductName,String description,Double discount,Double price, Integer productId,Integer typeId,String imageUrl)
    {

        Integer rows=productService.updateProduct(ProductName,description,discount,price,productId,typeId,imageUrl);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_3);
        }
    }
}
