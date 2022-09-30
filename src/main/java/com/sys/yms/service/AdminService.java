package com.sys.yms.service;

import com.sys.yms.entity.Admin;

public interface AdminService {
    Admin judge(String account, String password);
}
