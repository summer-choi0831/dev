package com.summer.dev.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/static/js/**")
                .addResourceLocations("classpath:/static/js/");

        registry.addResourceHandler("/static/css/**")
                .addResourceLocations("classpath:/static/css/");

        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/img/");
    }
}
