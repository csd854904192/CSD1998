package com.shar.sharingspring.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
       String uri = request.getRequestURI();

       //判断路径是登出还是登录验证，是这两者之一的话执行Controller中的定义的方法
        if (uri.endsWith("/admin/path/userLogin")||uri.endsWith("admin/Exit")||uri.endsWith("/admin/backLogin")){
            return true;
        }
        if (uri.endsWith("/admin/fPath/userLogin")||uri.endsWith("/admin/frontLogin")){
            return true;
        }

        if (request.getSession() != null && request.getSession().getAttribute("user") != null){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/admin/index");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
