package com.evan.seprojrearend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@MapperScan("com.evan.seprojrearend.mapper")
@ComponentScan
@SpringBootApplication(scanBasePackages="controller")
public class SeProjRearEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeProjRearEndApplication.class, args);
	}
}
