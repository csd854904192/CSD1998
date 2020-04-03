package com.shar.sharingspring.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/"+"/image/");
        registry.addResourceHandler("/back/**").addResourceLocations("/WEB-INF/"+"/back/");
        registry.addResourceHandler("/front/**").addResourceLocations("/WEB-INF/"+"/front/");
        registry.addResourceHandler("/layui/**").addResourceLocations("/layui/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns("/index",//配置哪些路径不被拦截
                "/back/**",
                "/front/**",
                "/layui/**",
                "/layui/**",
                "/js/**");


    }
}
