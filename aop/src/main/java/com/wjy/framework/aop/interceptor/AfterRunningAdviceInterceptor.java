package com.wjy.framework.aop.interceptor;

import com.wjy.framework.aop.Invocation.MethodInvocation;
import com.wjy.framework.aop.advisor.AfterRunningAdvice;

/**
 * 方法执行后拦截器
 * @author wjy
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor {
    /**
     * 引人通知
     */
    private AfterRunningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterRunningAdvice advice) {
        this.advice = advice;
    }

    /**
     * 方法调用
     * @param mi
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //先执行本身方法
        Object returnVal = mi.proceed();
        advice.after(returnVal,mi.getMethod(),mi.getArguments(),mi);
        return returnVal;
    }
}
