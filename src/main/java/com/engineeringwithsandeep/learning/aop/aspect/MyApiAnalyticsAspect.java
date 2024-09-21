package com.engineeringwithsandeep.learning.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
@Slf4j
public class MyApiAnalyticsAspect {

    // NOTE: has to be fully qualified path name
    @Before("com.engineeringwithsandeep.learning.aop.aspect.MyAopExpressions.forControllerPackageNoGetterSetter()")
    private void performAPIAnalytics() {
        log.info("====> Performing API Analytics  - for Account Controller class");
    }
}
