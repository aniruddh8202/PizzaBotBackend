package com.example.Temporary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {


    @Bean public OpenAPI customOpenAPI() { final String securitySchemeName =
            "bearerAuth";

        return new OpenAPI().info(getInfo()); }


    private Info getInfo() {
        final String apiTitle = "Pizza Ordering Bot";
        final String description = "A Chatbot that can let people order pizza online"
                + " The bot will display the menu to the customer. The user will select a pizza along with quantity and toppings"
                + " Special Discount will be provided to the customer if the order exceeds above 500. "
                + "The user will be able to place home address for delivery";
        return new Info().title(apiTitle).description(description).version("1.0.0").contact(getContact());
    }

    private Contact getContact() {
        return new Contact().name("Achyuth Vama").email("sree-achyutha.penmetcha@capgemini.com");
    }

}
