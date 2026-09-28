package com.example.aopdemo.aspect;

import com.example.aopdemo.dto.StudentDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String com.example.aopdemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint  joinPoint) {
//        Object[] arr = joinPoint.getArgs();
//        System.out.println("Student is going to be saved");
//    }

//    @AfterReturning(
//            value = "execution(* com.example.aopdemo.service.StudentService" +
//                    ".createStudent(..))",
//             returning = "result"
//    )
//    public void logAfterReturningMethod(StudentDTO result) {
//        String s="Target method returned: " + result;
//        System.out.println(s);
//        result.setName("Rohit");
//        result.setAge(30);
//
//    }

//    @AfterThrowing(
//            value = "execution(* com.example.aopdemo.service.StudentService" +
//                    ".createStudent(..))",
//            throwing = "exception"
//    )
//    public void logAfterThrowingMethod(Throwable exception) {
//        System.out.println("An error occurred");
//        System.out.println("Exception type:"+exception.getClass().getName());
//        System.out.println("Exception message: " + exception.getMessage());
//
//    }


//    @After(
//            value = "execution(* com.example.aopdemo.service.StudentService" +
//                    ".createStudent(..))"
//    )
//    public void logAfterMethod() {
//        System.out.println("After Method");
//
//    }

//    @Around(
//            value = "execution(* com.example.aopdemo.service.StudentService" +
//                    ".createStudent(..))"
//    )
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting :"+joinPoint.getSignature().getName());
//        try{
//        Object student =joinPoint.proceed();
//            System.out.println("Execution successfull");
//            return student;
//
//        }
//        catch(Exception e){
//            System.out.println("Exception Failed:"+e);
//            throw e;
//        }
//        finally{
//            System.out.println("After target method");
//        }
//
//
//
//
//    }

    @Around(
            value = "execution(* com.example.aopdemo.service.StudentService" +
                    ".dummyMethod(..))"
    )
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//Object[] arr = joinPoint.getArgs();
//String originalString=arr[0].toString();
//String modifiedString=originalString.toUpperCase();
//Object[] modifiedArr={
//        modifiedString
//};
//String returnType=(String) joinPoint.proceed(modifiedArr);
//returnType=returnType+ " : String Intercepted";
//return returnType;

        Object return1=joinPoint.proceed();
        System.out.println("Intercepted request calling again");
        Object return2=joinPoint.proceed();
        return return2;


    }

}
