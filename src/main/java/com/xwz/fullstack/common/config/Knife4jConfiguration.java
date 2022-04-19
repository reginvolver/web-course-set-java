package com.xwz.fullstack.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    // 地址 ip:port/doc
    @Bean(value = "fullStack")
    public Docket cloudMallApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("接口文档列表")
                        .description("web接口文档")
                        .termsOfServiceUrl("")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("WebJava")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.xwz.fullstack.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
