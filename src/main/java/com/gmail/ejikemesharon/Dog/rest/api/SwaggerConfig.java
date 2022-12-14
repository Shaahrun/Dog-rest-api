package com.gmail.ejikemesharon.Dog.rest.api;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request, please check the documentation for guidance" ),
        @ApiResponse(code = 401, message = "Due to security constraints, you are unauthorized to make this request"),
        @ApiResponse(code = 500, message = "Sorry, the server is currently down. Please make sure the Dog Microservice is running")
})
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dog API",
                "This returns a list of dogs specifying their breed and origin",
                "1.0",
                "null",
                new Contact("Sharon Ejikeme", "null", "ejikemesharon@gmail.com"),
                "License of API", "null", Collections.emptyList()
        );
    }
}
