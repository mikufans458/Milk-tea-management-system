package com.sys.yms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/loginPage")
    public String showLoginPage()
    {
        return "login";
    }

    @GetMapping("/mainPage")
    public String showMainPage()
    {
        return "mainPage";
    }

    @GetMapping("/welcome")
    public String showWelcome()
    {
        return "welcome";
    }

    /**
     * 响应商品类型管理页面
     * @return
     */
    @GetMapping("/typelistPage")
    public String showTypeListPage()
    {
        return "typelist";
    }

}
