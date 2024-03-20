package ru.mccormick.ipa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebMvcConfig {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("logIn");
    }
}