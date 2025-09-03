package com.produtinhos.produtinhos.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {
    @Bean
    OpenAPI configureSwagger() {
        return new OpenAPI().info(new Info()
                .title("Produtinhos Lindinhos")
                .description("Os produtos mais lindos de todo Brasil!")
                .summary("Api de gerenciamento de produtos")
                .version("v1.0.0")
                .license(new License()
                        .url("https://github.com/gustavodscruz/produtinhos")
                        .name("Licença - Produtinhos Lindinhos - v1.0.0"))
                .termsOfService("Termos de Serviço")

        ).addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", createApiKeyScheme()));
    }

    private SecurityScheme createApiKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
