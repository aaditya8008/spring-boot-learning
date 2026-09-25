package com.example.filterdemo.filter;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @Component 
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
         HttpServletRequest httpServletRequest = (HttpServletRequest) request;        
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        BufferedReader reader=httpServletRequest.getReader();
        StringBuilder requestBody=new StringBuilder();
        String line=reader.readLine();
        while(line!=null){
            requestBody.append(line);
            line=reader.readLine();
        }
        System.out.println(requestBody);
        chain.doFilter(request, response);

    }
   
    
}
