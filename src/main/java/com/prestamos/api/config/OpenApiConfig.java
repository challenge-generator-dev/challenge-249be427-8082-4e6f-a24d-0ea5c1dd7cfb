package com.prestamos.api.config;

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
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:" + serverPort);
        server.setDescription("Servidor de desarrollo local");

        Contact contact = new Contact();
        contact.setName("Equipo de Desarrollo");
        contact.setEmail("desarrollo@prestamos.com");
        contact.setUrl("https://prestamos.com");

        License license = new License();
        license.setName("Apache 2.0");
        license.setUrl("https://www.apache.org/licenses/LICENSE-2.0.html");

        Info info = new Info();
        info.setTitle("API de Gestión de Préstamos");
        info.setVersion("1.0.0");
        info.setDescription("""
                API REST para la gestión de solicitudes de préstamos bancarios.
                
                Permite realizar operaciones CRUD sobre préstamos con las siguientes características:
                
                - **Monto**: Valor numérico positivo que representa la cantidad solicitada
                - **Tasa de interés**: Porcentaje entre 0 y 100
                - **Plazo**: Número entero positivo de cuotas
                
                La API valida todos los campos antes de persistir en la base de datos.
                """);
        info.setContact(contact);
        info.setLicense(license);

        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(info);
        openAPI.setServers(List.of(server));

        return openAPI;
    }
}