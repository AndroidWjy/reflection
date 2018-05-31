package com.wjy.framework.aop.core;

import com.wjy.framework.aop.Invocation.CglibMethodInvocation;
import com.wjy.framework.aop.Invocation.MethodInvocation;
import com.wjy.framework.aop.advisor.TargetSource;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 动态拦截，实现cglib的拦截器方法
 * @author wjy
 */
public class DynamicAdvisedInterceptor implements MethodInterceptor{

    protected final List<AopMethodInterceptor> interceptorList;
    protected final TargetSource targetSource;

    public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorList, TargetSource targetSource) {
        this.interceptorList = interceptorList;
        this.targetSource = targetSource;
    }

    /**
     * 回调时调用
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //织入增强代码的方法，串联起本地拦截器
        MethodInvocation invocation = new CglibMethodInvocation(obj,targetSource.getTargetObject(),method, args,interceptorList,proxy);
        return invocation.proceed();
    }
}
