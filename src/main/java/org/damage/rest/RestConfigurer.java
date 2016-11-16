package org.damage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RestConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private UpdateMessageInterceptor updateMessageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(updateMessageInterceptor).addPathPatterns("/**");
    }
}
