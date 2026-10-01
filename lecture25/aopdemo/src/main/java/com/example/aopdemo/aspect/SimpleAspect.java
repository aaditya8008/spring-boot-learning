package com.example.aopdemo.aspect;

import com.example.aopdemo.annotation.TrackExecutionTime;
import com.example.aopdemo.dto.StudentDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    // @Before ("@annotation()")
    // public void logBeforeMethod(){
    //    System.out.println("Before method called");
    // }

    @Around ("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
        TrackExecutionTime trackExecutionTime
    ) throws Throwable {

        long startTime = System.currentTimeMillis();
        try {
            System.out.println("Before method called");
            Thread.sleep(2000); // Simulating a delay of 1 second
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            String operationName = trackExecutionTime.operation();
            long warnAfter = trackExecutionTime.warnAfter();
            String methodName = joinPoint.getSignature().getName();
            if (endTime - startTime > warnAfter) {
                System.out.println("Warning: Execution time of " + methodName + " exceeded threshold of " + warnAfter + " ms");
            }
            System.out.println("Operation: " + operationName);
            System.out.println("Execution time of " + methodName + " is " + (endTime - startTime) + " ms");
        }

    }
}
