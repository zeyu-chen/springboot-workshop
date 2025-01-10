package dev.zeyuchen.banking_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI bankingOpenAPI() {
        return new OpenAPI().info(new Info().title("Banking API")
                .description("Banking application REST API documentation").version("1.0")
                .contact(new Contact().name("Zeyu Chen").email("contact@zeyuchen.dev")));
    }
}
