package com.wjy.framework.aop.interceptor;


import com.wjy.framework.aop.Invocation.MethodInvocation;

/**
 * @author wjy
 * 方法的拦截器
 */
public interface AopMethodInterceptor {
    /**
     * 对方法拦截
     * @param mi
     * @return
     * @throws Throwable
     */
    Object invoke(MethodInvocation mi) throws Throwable;

}
