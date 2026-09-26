package com.example.aopintroductiondemoapplication.service;


public class LoggingServiceUtil {
    public static void logStart(String className,String methodName){
        System.out.println("Executing -> "+className+" : "+methodName);
    }

    public static void logEnd(String classname,String methodName){
        System.out.println("Finishing -> "+classname+" : "+methodName);
    }
}
