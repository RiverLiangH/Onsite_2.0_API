/**
 * Copyright (C), 2023-02-06
 * FileName: SwaggerConfig
 * Author:   Lv
 * Date:     2023/2/6 17:59
 * Description: swagger的config配置类
 */
package com.evan.seprojrearend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    private static ApiInfo DEFAULT = null;
    @Bean
    public Docket docket() {
        Contact DEFAULT_CONTACT = new Contact("Onsite2.0", "https://github.com/RiverLiangH/Onsite_2.0_API", "1031903858@qq.com");
        DEFAULT = new ApiInfo(
                "Onsite2.0开发接口",
                "Api Documentation",
                "V-1.0",
                "https://github.com/RiverLiangH/Onsite_2.0_API",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT);
    }
}
