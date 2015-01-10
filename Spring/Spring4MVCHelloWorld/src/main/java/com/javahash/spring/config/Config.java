package com.javahash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan(basePackages={"com.javahash.spring.controller"})
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter{

	@Bean
	public UrlBasedViewResolver setUpViewResolver(){
		InternalResourceViewResolver urlBasedViewResolver = new InternalResourceViewResolver();
		urlBasedViewResolver.setPrefix("/");
		urlBasedViewResolver.setSuffix(".jsp");
		urlBasedViewResolver.setViewClass(JstlView.class);
		return urlBasedViewResolver;
	}
}
