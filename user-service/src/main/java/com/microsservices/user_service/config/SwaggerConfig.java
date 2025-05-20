package com.microsservices.user_service.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Microsserviço de Usuário",
                version = "1.0.0",
                description = "Api de Usuários do projeto de Microsserviços com RabbitMQ.",
                contact = @Contact(
                        name = "Rafael"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8079", description = "Servidor local")
        }
)
public class SwaggerConfig {}