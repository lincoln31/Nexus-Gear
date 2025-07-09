package com.nexusgear.productservice.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Aplica la configuración a todas las rutas bajo /api/
                .allowedOrigins("http://localhost:5173") // Permite peticiones desde el origen de nuestro frontend Vite
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite estos métodos HTTP
                .allowedHeaders("*") // Permite todas las cabeceras
                .allowCredentials(true);
    }
}