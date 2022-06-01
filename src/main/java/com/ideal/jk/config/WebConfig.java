package com.ideal.jk.config;

import com.ideal.jk.prop.JKProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JKProperties jkProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(jkProperties.getPropConfig().getCorsOrigins())
                .allowCredentials(true)
                .allowedMethods("GET", "POST");
    }
}
