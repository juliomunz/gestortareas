package challenge.app.gestortareas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI gestorTareasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Gestor de Tareas")
                        .version("1.0.0")
                        .description("Documentación de la API REST para gestionar proyectos y tareas.")
                        .contact(new Contact()
                                .name("Tu Nombre o Empresa")
                                .email("tu.email@ejemplo.com")));
    }
}
