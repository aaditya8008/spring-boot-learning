package com.example.filterdemo.filter;

import java.io.IOException;

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
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, 
        ServletResponse response, 
        FilterChain chain)
            throws IOException, ServletException {
       HttpServletRequest httpRequest = (HttpServletRequest) request;
       HttpServletResponse httpResponse = (HttpServletResponse) response;
       String token=  httpRequest.getHeader("token");
       String apiKey=  httpRequest.getHeader("X-API-KEY");
       if(token==null || !token.equals("12345")) {
           httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return;
       }
       if(apiKey==null || !apiKey.equals("secret123")) {
           httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           httpResponse.setContentType("application/json");
           httpResponse.getWriter().write("{\"error\": \"Invalid API Key\"}");
              return;
       }
         chain.doFilter(request, response);
    }
    
}
