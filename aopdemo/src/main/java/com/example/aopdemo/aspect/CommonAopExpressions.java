package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect

public class CommonAopExpressions {
    // let's start with an @Before advice
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    // create a pointcut for setter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
