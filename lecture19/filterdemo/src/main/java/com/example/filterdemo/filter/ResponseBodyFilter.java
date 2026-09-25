package com.example.filterdemo.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component 
public class ResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
         HttpServletRequest httpServletRequest = (HttpServletRequest) request;        
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
        chain.doFilter(request, responseWrapper);
        byte[] originalBodayBytes=responseWrapper.getContentAsByteArray();
        String originalBody=new String(originalBodayBytes);
        String modifiedBody="""
                {
        "originalResponse": %s,
        "appName":"Student Management System",
        }
                """.formatted(originalBody);
                responseWrapper.resetBuffer();
                responseWrapper.getWriter().write(modifiedBody);
                responseWrapper.copyBodyToResponse();
    }
    
}
