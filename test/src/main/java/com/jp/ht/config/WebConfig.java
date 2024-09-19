package com.jp.ht.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jp.ht.interceptors.LoginInterceptors;
@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	private LoginInterceptors loginInterceptors;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptors).excludePathPatterns("/user","/admin/login","/admin/register");//login許可
	}

}
