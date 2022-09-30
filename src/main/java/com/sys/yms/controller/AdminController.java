package com.sys.yms.controller;

import com.sys.yms.entity.Admin;
import com.sys.yms.service.impl.AdminServiceImpl;
import com.sys.yms.util.ResponseCode;
import com.sys.yms.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminServiceImpl adminServiceImpl;

    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(String account, String password, HttpSession session)
    {
        //调用service
        Admin admin = adminServiceImpl.judge(account, password);
        //判断admin是否为空
        if(admin!=null)
        {
            //账号密码正确
            //向域对象中存入数据
            session.setAttribute("adminInfo",admin);
            return new ResponseData(ResponseCode.SUCCESS);
        }
        //若不正确
        return new ResponseData(ResponseCode.ERROR_1);
    }
    @RequestMapping("/logout")
    public String LogOut(HttpSession session)
    {
        session.invalidate();
        return "forward:/mainPage";
    }
}
