package com.engineeringwithsandeep.learning.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

    @Pointcut("execution(* com.engineeringwithsandeep.learning.aop.account.AccountController.*(..))")
    public static void forAccountController() {
    }

    @Pointcut("execution(* com.engineeringwithsandeep.learning.aop.account.*.get*(..)))")
    public static void forGetter() {
    }

    @Pointcut("execution(* com.engineeringwithsandeep.learning.aop.account.*.set*(..))")
    public static void forSetter() {
    }

    @Pointcut("execution(* com.engineeringwithsandeep.learning.aop.account.*.add*(..))")
    public static void forAddAccount() {
    }

    @Pointcut("execution(* com.engineeringwithsandeep.learning.aop.account.*.find*(..))")
    public static void forFindAccount() {
    }
    
    @Pointcut("forAccountController() && !(forGetter() || forSetter())")
    public static void forControllerPackageNoGetterSetter() {
    }
}
