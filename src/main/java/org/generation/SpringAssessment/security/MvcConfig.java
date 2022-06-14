package org.generation.SpringAssessment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/taskform").setViewName("taskform");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //expose the image, js, css resources to the client (browser) so that they can access the necessary files to display
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }
}
