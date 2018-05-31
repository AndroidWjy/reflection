package com.wjy.framework.aop.interceptor;

import com.wjy.framework.aop.Invocation.MethodInvocation;
import com.wjy.framework.aop.advisor.BeforeMethodAdvice;

/**
 * 方法执行前
 * @author wjy
 */
public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {

    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        advice.before(mi.getMethod(),mi.getArguments(),mi);
        return mi.proceed();
    }
}
