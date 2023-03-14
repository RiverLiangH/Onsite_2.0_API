/**
 * Copyright (C), 2023-02-13
 * FileName: WebConfiguration
 * Author:   Lv
 * Date:     2023/2/13 21:04
 * Description: WebConfiguration类(配置拦截器)
 */
package com.evan.seprojrearend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 解决跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
//                .allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);
    }

    /**
     * 异步请求配置
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

    /**
     * 配置拦截器、拦截路径
     * 每次请求到拦截的路径，就会去执行拦截器中的方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
        excludePath.add("/user/login");  //登录
        excludePath.add("/user/sign_up");     //注册
        excludePath.add("/user/validate_username");  //判断用户名是否存在

        excludePath.add("/scene/scene_user");
        excludePath.add("/scene/get_scene_msg");
        excludePath.add("/user/validate_mobile");
        excludePath.add("/user/validate_email");
        excludePath.add("/doc.html");     //swagger
        excludePath.add("/swagger-ui.html");     //swagger
        excludePath.add("/swagger-resources/**");     //swagger
        excludePath.add("/v2/api-docs");     //swagger
        excludePath.add("/webjars/**");     //swagger
        excludePath.add("/token");
//        excludePath.add("/user/check_msg");  //查询信息
//        excludePath.add("/user/modify_password");  //查询信息
        excludePath.add("/user/modify_msg");  //修改信息

        excludePath.add("/scene/find_by_paging");
        excludePath.add("/entry/competitions_take_count");
        excludePath.add("/competition/all_competitions");
        excludePath.add("/competition/competition_info");
        excludePath.add("/submit/find_by_paging");
//        excludePath.add("/test");
//        excludePath.add("/scene/find_by_paging");
//        excludePath.add("/static/**");  //静态资源
//        excludePath.add("/assets/**");  //静态资源
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
