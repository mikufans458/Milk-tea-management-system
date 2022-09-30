package com.sys.yms.service.impl;

import com.sys.yms.entity.Admin;
import com.sys.yms.mapper.AdminMapper;
import com.sys.yms.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;
    public Admin judge(String account, String password)
    {
       return adminMapper.judge(account,password);
    }
}
