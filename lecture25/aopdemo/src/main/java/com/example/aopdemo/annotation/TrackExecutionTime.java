package com.example.aopdemo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented 
public @interface  TrackExecutionTime {
    long warnAfter() default 2000; // Default threshold of 2 second
    String operation() default ""; // Default operation name

}
