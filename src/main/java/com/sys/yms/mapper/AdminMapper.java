package com.sys.yms.mapper;

import com.sys.yms.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    /**
     * 根据账号、密码查询admin的数据
     * @param account
     * @param password
     * @return
     */
    Admin judge(@Param("account") String account,
                @Param("password") String password);
}
