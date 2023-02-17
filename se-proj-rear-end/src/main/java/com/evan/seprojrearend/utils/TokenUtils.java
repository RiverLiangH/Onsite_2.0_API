/**
 * Copyright (C), 2023-02-13
 * FileName: TokenUtils
 * Author:   Lv
 * Date:     2023/2/13 20:53
 * Description: token工具类（用来生成token以及效验token）
 */
package com.evan.seprojrearend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.evan.seprojrearend.po.User;

import java.util.Date;

public class TokenUtils {
    /**
     * 对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
     * 如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象
     * **/

    //token到期时间10小时
    private static final long EXPIRE_TIME = 10*60*60*1000;
    //密钥
    private static final String TOKEN_SECRET = "ljdyaishijin**3nkjnj??";
    //token发行人
    private static final String ISSUER = "auth0";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String sign(User user){

        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer(ISSUER)
                    //存放数据
                    .withClaim("username",user.getUsername())
                    //过期时间
                    .withExpiresAt(expireAt)
                    //加密算法
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException|JWTCreationException je) {
            System.out.println("token创建失败");
        }
        return token;
    }

    /**
     * token验证
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("username: " + decodedJWT.getClaim("username").asString());
            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }
}
