package com.sys.yms;

import com.sys.yms.entity.Admin;
import com.sys.yms.entity.Product;
import com.sys.yms.entity.Type;
import com.sys.yms.mapper.AdminMapper;
import com.sys.yms.mapper.ProductMapper;
import com.sys.yms.mapper.TypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class YmsApplicationTests {

    @Resource
    AdminMapper adminMapper;
    @Resource
    TypeMapper typeMapper;
    @Resource
    ProductMapper productMapper;
    @Test
    void contextLoads() {
        Admin judge = adminMapper.judge("admin", "admin123");
        System.out.println(judge);
    }
    @Test
    void test01()
    {
        List<Product> products = productMapper.queryByPage(1, 10, "1杯", "黑茶", 5.0, 10.0);
        for (Product product : products) {
            System.out.println(product);
        }
    }


}
