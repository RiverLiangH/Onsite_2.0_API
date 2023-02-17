/**
 * Copyright (C), 2023-02-13
 * FileName: TokenInterceptor
 * Author:   Lv
 * Date:     2023/2/13 20:44
 * Description: TokenInterceptor类（拦截器）
 */
package com.evan.seprojrearend.config;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    /**
     * token拦截器，对请求进行token验证
     * **/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getHeader("token"));    // test

        if (request.getMethod().equals("OPTIONS")) {
            //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
            response.setStatus(HttpServletResponse.SC_OK);  //200
            return true;
        }

        response.setCharacterEncoding("utf-8"); //设置编码格式
        String token = request.getHeader("token");
        //token不为null：进行token验证
        if (token != null) {
            boolean result = TokenUtils.verify(token);  // TODO 验证token
            if (result) {
                System.out.println("通过拦截器");
                return true;
            }
        }

        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json = new JSONObject();
            json.put("msg", "token verify fail");
            json.put("code", "500");
            response.getWriter().append(json.toString());
            System.out.println("认证失败，未通过拦截器");
        } catch (Exception e) {
            return false;
        }

        /**
         * 还可以在此处检验用户存不存在等操作
         */
        return false;
    }
}
