package com.wjy.aspect.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;


/**
 * @author wangjinyang@g7.com.cn
 */
@Component
@Aspect
public class WebControllerAop {
    /**
     * 匹配com.wjy.aspect.controller包及其子包下的所有类的方法
     */
    @Pointcut("execution(* com.wjy.aspect.controller..*.*(..))")
    public void executeService() {

    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("我是前置通知");
        //获取目标方法参数信息
        Object[] objects = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理目标对象
        joinPoint.getTarget();
        //通知的签名
        Signature signature = joinPoint.getSignature();
        //aop代理的方法
        System.out.println("代理方法：" + signature.getName());
        System.out.println("代理类的名字：" + signature.getDeclaringTypeName());

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //获取session的信息
        HttpSession httpSession = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

        Enumeration<String> parameterNames = request.getParameterNames();
        HashMap<String, String> params = new HashMap<>();
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            params.put(parameter, request.getParameter(parameter));
        }
        System.out.println("请求参数：" + params.toString());
    }

    /**
     * 后置返回通知
     * 这里需要注意的是:
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
     * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     *
     * @param joinPoint
     * @param keys
     */
    @AfterReturning(value = "execution(* com.wjy.aspect.controller..*.*(..))", returning = "keys")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object keys) {
        System.out.println("第一个后置返回的返回值：" + keys);
    }

    @AfterReturning(value = "execution(* com.wjy.aspect.controller..*.*(..))", returning = "keys")
    public void doAfterReturningAdviceInString(String keys) {
        System.out.println("第一个后置返回的返回值：" + keys);
    }

    /**
     * 当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，
     * 否则不执行，对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "executeService()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println(joinPoint.getSignature().getName());
        if (exception instanceof NullPointerException) {
            System.out.println("发生空指针异常");
        }
    }

    /**
     * 执行后置通知
     *
     * @param joinPoint
     */
    @After("executeService()")
    public void doAfterAdvice(JoinPoint joinPoint) {
        System.out.println("后置通知执行了");
    }

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，
     * 执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around("executeService()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知之前：" + proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            System.out.println("环绕执行之后：" + obj);
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
