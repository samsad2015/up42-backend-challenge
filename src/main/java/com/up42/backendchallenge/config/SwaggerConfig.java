package com.up42.backendchallenge.config;


import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.up42.backendchallenge.feature.controller"))
                .paths(PathSelectors.regex("/api/v1.*"))
                .build().apiInfo(carApiInfo());
    }

    private ApiInfo carApiInfo() {
        return new ApiInfoBuilder().title("Code Challenge Documentation")
                .description("Code Challenge Documentation Description")
                .contact(new Contact("Samsad Hasan", "https://www.linkedin.com/in/samsad-hasan/", "samsadhasan@hotmail.com"))
                .version("0.0.1")
                .build();
    }
}
