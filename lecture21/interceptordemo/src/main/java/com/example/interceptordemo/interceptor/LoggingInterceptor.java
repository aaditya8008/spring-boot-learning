package com.example.interceptordemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class LoggingInterceptor implements HandlerInterceptor {
    
    @Override 
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("preHandle method called");
       System.out.println("Request URI: " + request.getRequestURI());
       System.out.println("Request Method: " + request.getMethod());
       System.out.println("Request Parameters: " + request.getQueryString());
       System.out.println("Client IP Address: " + request.getRemoteAddr());
       System.out.println("Token Value: " + request.getHeader("token"));
       if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println("Handler Method: " + handlerMethod.getMethod().getName());
            System.out.println("Handler Class: " + handlerMethod.getBeanType().getName());
        }
        return true; 
    }

   

    @Override 
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion method called");
        System.out.println("Response status: "+response.getStatus());
    }
}
