package dev.zeyu.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Restful Webservices", version = "1.0.0",
        description = "Demo project for Spring Boot Restful Webservices",
        contact = @Contact(name = "Zeyu Chen", email = "iszeyu.chen@gmail.com")))
public class SpringbootRestfulWebservicesApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(final String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }

}
