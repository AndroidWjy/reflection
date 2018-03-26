package com.wjy.framework.aop.interceptor;


import com.wjy.framework.aop.Invocation.MethodInvocation;

/**
 * 方法的拦截器
 */
public interface AopMethodInterceptor {

    Object invoke(MethodInvocation mi) throws Throwable;

}
