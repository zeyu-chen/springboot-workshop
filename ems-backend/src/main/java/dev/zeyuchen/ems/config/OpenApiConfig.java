package dev.zeyuchen.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Employee Management System API").version("1.0")
                .description("Spring Boot REST API for Employee Management System")
                .contact(new Contact().name("Zeyu Chen").email("iszeyu.chen@gmail.com"))
                .license(new License().name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
