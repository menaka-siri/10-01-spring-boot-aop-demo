package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class MyDemoLoggingAspect {

//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())") // inside the brackets is the pointcut
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.example.aopdemo.Account))")
//    @Before("execution(* add*(com.example.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()")
    @Before("com.example.aopdemo.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() { // this method can be any name
        System.out.println("\n=========>>> Executing @Before advice on method");
    }
}
