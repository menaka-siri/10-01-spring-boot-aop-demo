package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {

    }

//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())") // inside the brackets is the pointcut
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.example.aopdemo.Account))")
//    @Before("execution(* add*(com.example.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() { // this method can be any name
        System.out.println("\n=========>>> Executing @Before advice on method");
    }
}
