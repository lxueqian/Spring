package com.xq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect /* <!--声明切面:切点+通知--> <aop:aspect ref="myAspect">*/
public class MyAspect {

    @Before("execution(* com.xq.aop.*.*(..))") //配置前置增强 把这个方法用在（）中方法增强
    public void beforeMethod(){
        System.out.println("前置增强....");
    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕方法前增强");
        Object proceed = pjp.proceed();//切点方法执行 有没有返回值都可以
        System.out.println("环绕方法后执行");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常抛出增强....");
    }
    //使用切点表达式
    @AfterReturning("MyAspect.pointcut()")
    public void afterReturning(){
        System.out.println("后置增强....");
    }

    public void finall(){
        System.out.println("最终增强....");
    }
    //不论异常是否抛出都会执行最终增强

    //抽取切点表达式
    @Pointcut("execution(* com.xq.aop.*.*(..))")
    public void pointcut(){}
}
