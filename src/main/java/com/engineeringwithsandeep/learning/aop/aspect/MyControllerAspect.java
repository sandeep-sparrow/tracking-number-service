package com.engineeringwithsandeep.learning.aop.aspect;

import com.engineeringwithsandeep.learning.aop.account.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(2)
@Aspect
@Component
@Slf4j
public class MyControllerAspect {

    @Around("execution(* com.engineeringwithsandeep.learning.aop.traffic.*.getFortune(..))")
    public Object aroundGetTrafficFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        // print out method we are advising on
        log.info("\n====> Executing @Around method: {}", joinPoint.getSignature().toString());

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result;
        try  {
             result = joinPoint.proceed();
        } catch (Exception ex) {
            log.info("\n====> Exception: {}", ex.getMessage());
            // re-throw exception
            throw ex;
        }
        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        log.info("\n====> Duration: {} seconds", duration / 1000.0);
        return result;
    }

    @After("com.engineeringwithsandeep.learning.aop.aspect.MyAopExpressions.forFindAccount()")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toString();
        log.info("====> Executing @After method: {}", method);
    }

    @AfterThrowing(pointcut = "com.engineeringwithsandeep.learning.aop.aspect.MyAopExpressions.forFindAccount()",
            throwing = "ex")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable ex) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toString();
        log.info("====> Executing @AfterThrowing method: {}", method);

        // Exception
        log.info("====> The Executing is: {}", ex.getMessage());
    }

    @AfterReturning(pointcut = "com.engineeringwithsandeep.learning.aop.aspect.MyAopExpressions.forFindAccount()",
                    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toString();
        log.info("====> Executing @AfterReturning on method: {}", method);

        // print out result
        printResult(result);

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        printResult(result);
    }

    // POST PROCESSING with help of @AfterReturning Advice
    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperName = account.getAccountName().toUpperCase();
            account.setAccountName(upperName);
        }
    }

    // NOTE: has to be fully qualified path name
    @Before("com.engineeringwithsandeep.learning.aop.aspect.MyAopExpressions.forAddAccount()")
    private void beforeAddAccountAdvice(JoinPoint joinPoint) {

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("====> Executing @BeforeAdvice on method: {}", methodSignature);

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object arg : args) {
            if (arg instanceof Account theAccount) {
                printResult(arg.toString());
                // downcast and print Account specific stuff
                log.info("====> account name: {}", theAccount.accountName);
                log.info("====> account number: {}", theAccount.accountNumber);
            }
        }
    }

    private static void printResult(Object result) {
        log.info("====> Result is: {}", result);
    }
}
