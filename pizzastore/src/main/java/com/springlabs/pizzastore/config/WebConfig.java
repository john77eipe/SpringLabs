package com.springlabs.pizzastore.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	/**
	 * View resolver is needed because we have placed the jsp files
	 * at not the default location but under a custom one.
	 * @return
	 */

	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/jsp/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	/**
	 * Using resource handlers we say where the css, js, images and other static 
	 * content are present.
	 * 
	 * Notice that for css and js (in my case) are under src/main/resources
	 */
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		
		  // Register resource handler for CSS
	      registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	      
	      // Register resource handler for JS
	      registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/")
          	.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

	      // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

}
