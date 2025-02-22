package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(100)
public class MyDemoLoggingAspect {

    @AfterThrowing (
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))" ,
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint  theJoinPoint, Throwable theExc) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> Exception is: " + theExc);


    }

    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> result is: " + result);

        // let's post-process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount: result) {
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    //    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())") // inside the brackets is the pointcut
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.example.aopdemo.Account))")
//    @Before("execution(* add*(com.example.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()")
    @Before("com.example.aopdemo.aspect.CommonAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // this method can be any name
        System.out.println("\n=========>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        //display method arguments
        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for (Object tempArg: args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }
}
