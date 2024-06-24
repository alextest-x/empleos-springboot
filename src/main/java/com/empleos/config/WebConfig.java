package com.empleos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
    inyectando la ruta en rutaImagenes;
    @Value("${empleosapp.ruta.imagenes}")
    */

    @Value("${empleosapp.ruta.imagenes}")
    private String rutaImagenes;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      //registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/"); // Linux
      //registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/empleos/img-vacantes/"); // Windows

        registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes);

    }
}

