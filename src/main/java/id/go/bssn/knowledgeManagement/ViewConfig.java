package id.go.bssn.knowledgeManagement;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ViewConfig extends SpringBootServletInitializer {

    @Bean
    public WebMvcConfigurerAdapter configureWebapp() {
        return new WebMvcConfigurerAdapter() {
            
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
            	// Mengarahkan ke Index.html dan Login.html pada /src/templates/
                registry.addViewController("/").setViewName("index");
                //registry.addViewController("/login").setViewName("login");
            }
        };
    }
    
}