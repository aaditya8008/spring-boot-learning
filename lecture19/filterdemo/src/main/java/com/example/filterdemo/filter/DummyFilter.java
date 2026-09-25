package com.example.filterdemo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class DummyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;        
        String uri=httpServletRequest.getRequestURI();
        if(uri.startsWith("/api/")){
            chain.doFilter(request, response);
        }
        if(uri.startsWith("/api/"))
        System.out.println("Dummy Filter executed");
        chain.doFilter(request, response);
    }
    
    
}
