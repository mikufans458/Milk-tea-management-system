package com.sys.yms.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断session是否有数据
        if(request.getSession().getAttribute("adminInfo")!=null)
        {
            //对请求放行
            return true;
        }
        //重定向到登录页面
        response.sendRedirect("/loginPage");
        //拦截请求
        return false;
    }
}
