package br.com.consulting_delivery.data_manager.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoSpringDoc {
    public ConfiguracaoSpringDoc() {
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return (
                new OpenAPI()).info((
                        new Info())
                .title("Javer Data Manager")
                .description("Micro serviço de operações CRUD no banco de dados"));
    }
}
