package com.example.specification.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${api.dev.url}")
    private String devUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        // Define development server
        Server devServer = new Server()
                .url(devUrl)
                .description("Development Server");

        // Define contact information
        Contact contact = new Contact()
                .email("farzan.6118@gmail.com")
                .name("Farzan Saketi")
                .url("https://github.com/Farzan6118/");

        // Define license information
        License mitLicense = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        // Define API info
        Info apiInfo = new Info()
                .title("specification criteria API sample Service")
                .version("1.0")
                .contact(contact)
                .termsOfService("https://github.com/Farzan6118/")
                .license(mitLicense);

        // Return the configured OpenAPI instance (بدون bearer/jwt)
        return new OpenAPI()
                .info(apiInfo)
                .servers(List.of(devServer));
    }
}
