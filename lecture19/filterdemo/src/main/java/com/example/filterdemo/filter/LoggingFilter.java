package com.example.filterdemo.filter;

import java.io.IOException;
import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, 
        ServletResponse response, 
        FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
       HttpServletRequest httpRequest = (HttpServletRequest) request;
       HttpServletResponse httpResponse = (HttpServletResponse) response;
       String requestId=UUID.randomUUID().toString();
       httpResponse.setHeader("X-Request-ID", requestId);
       System.out.println("Incoming request: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
       try {
           chain.doFilter(request, response);
       } finally {
           long duration = System.currentTimeMillis() - startTime;
           System.out.println("Outgoing response: " + httpResponse.getStatus());
           System.out.println("Request processing time: " + duration + " ms");
       }
    }
    
}
