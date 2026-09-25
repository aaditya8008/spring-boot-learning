package com.example.filterdemo.Configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filterdemo.filter.DummyFilter;

@Configuration 
public class FilterConfig {
    
    @Bean 
    public FilterRegistrationBean<DummyFilter> getDummyFilter(){
        FilterRegistrationBean<DummyFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new DummyFilter());
        filterRegistrationBean.addUrlPatterns("/api/students/*");
        return filterRegistrationBean;
    }
}
