package com.example.blcd.beanlifecycledemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
public class CartService implements BeanNameAware, ApplicationContextAware  /*implements InitializingBean, DisposableBean*/{

    Map<Integer, String> mp;

    public CartService() {
        mp = new HashMap<>();
        mp.put(1, "Aaditya");
        mp.put(2, "Rohit");
        System.out.println("CartService contructor called");
    }
    
    public void addToCart() {
        System.out.println("Added to cart");
    }

    public String getValue(int key) {
        return mp.get(key);
    }


    @PostConstruct
    public void start2() {
        System.out.println("Initialization callback");
        mp.put(1, "Aaditya");
        mp.put(2, "Rohit");
    }

    @PreDestroy
    public void stop() {
        mp.clear();
        System.out.println("Bean is getting destroyed");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is "+applicationContext.getClass());  
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: "+name);
    }

    // public void stop() {
    //     mp.clear();
    //     System.out.println("Bean is getting destroyed");
    // }


    // @Override
    // public void destroy() throws Exception {
    //     mp.clear();
    //     System.out.println("Bean is getting destroyed");
    // }

    //  public void start() {
    //     System.out.println("Initialization callback");
    //     mp.put(1, "Aaditya");
    //     mp.put(2, "Rohit");
    // }

    // @Override
    // public void afterPropertiesSet() throws Exception {
    //     System.out.println("Initialization callback");
    //     mp.put(1, "Aaditya");
    //     mp.put(2, "Rohit");
    // }
}
