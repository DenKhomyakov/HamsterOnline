package com.hamsteronline.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ToDo: Добавить JavaDoc, email
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hamsterOnlineOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hamster Online API")
                        .description("REST API для мессенджера Hamster Online")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Hamster Team")
                                .email("")));
    }
}
