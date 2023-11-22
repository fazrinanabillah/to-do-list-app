package com.fazrina.simpleappone.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "To Do List",
        version = "1.0",
        contact = @Contact(
                name = "Fazrina Nabillah",
                url = "https://github.com/fazrinanabillah"
        )
))
public class OpenAPIConfiguration {
}
