package com.sys.yms.mapper;

import com.sys.yms.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    /**
     * 分页查询product数据
     * @param startIndex
     * @param limit
     * @return
     */
    List<Product> queryByPage(@Param("s") Integer startIndex
                            ,@Param("l") Integer limit
                            ,@Param("pn") String productName
                            ,@Param("pt") String productType
                            ,@Param("pmin") Double price_min
                            ,@Param("pmax") Double price_max
    );

    /**
     * 查询产品数据量
     * @param productName
     * @param productType
     * @param price_min
     * @param price_max
     * @return
     */
    Integer productCount(@Param("pn") String productName
            ,@Param("pt")String productType
            ,@Param("pmin") Double price_min
            ,@Param("pmax") Double price_max
    );

    /**
     * 更新产品信息
     * @param product
     * @return
     */
    Integer updateProduct(Product product);

    /**
     * 添加商品
     * @param product
     * @return
     */
    Integer insertProduct(Product product);

    //修改状态
    Integer updateProductStateById(@Param("id") Integer id,@Param("productState") Integer productState);

    //修改热饮状态
    Integer updateProductHotStateById(@Param("id") Integer id,@Param("productHotState") Integer productHotState);

    //删除商品
    Integer deleteById(Integer id);
}
