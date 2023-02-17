package com.evan.seprojrearend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags="HelloController接口测试")
@RestController
@CrossOrigin
public class HelloController {
    @ApiOperation(value="用户登录",notes="点击显示hello world即测试成功")
    @RequestMapping("/test")
    public String hello(){
        return "hello world";
    }

    @GetMapping("token")
    public String getToken(HttpServletRequest request){
        return request.getHeader("token");
    }

}
