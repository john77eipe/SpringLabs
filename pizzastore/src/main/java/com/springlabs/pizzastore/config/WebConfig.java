package com.springlabs.pizzastore.config;


import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.swing.*;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {



	/**
	 * Thymeleaf template resolver serving HTML 5
	 * Template resolver resolves templates into TemplateResolution Objects that contain additional code such as
	 * template mode, caching, prefix, suffix, etc.
	 * ClassLoaderTemplateResolver is used for loading templates located on the classpath
	 * @return
	 */
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {

		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setPrefix("templates/"); //this is the default directory; this is mandatory if changed
		templateResolver.setCacheable(false);
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");

		return templateResolver;
	}

	/**
	 * Thymeleaf template engine with Spring integration
	 * @return
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());

		return templateEngine;
	}

	/**
	 * Thymeleaf view resolver
	 * View resolvers are responsible for obtaining View objects for a specific operation and locale.
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {

		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");

		return viewResolver;
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
