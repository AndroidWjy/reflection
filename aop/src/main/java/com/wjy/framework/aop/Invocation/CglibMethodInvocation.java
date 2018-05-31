package com.wjy.framework.aop.Invocation;

import com.wjy.framework.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 描述一个方法调用，不是调用这个动作
 * @author wjy
 */
public class CglibMethodInvocation extends ReflectiveMethodInvocation {
    /**
     * 引入cglib的方法代理
     */
    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList, MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy = methodProxy;
    }

    @Override
    protected Object invokeOriginal() throws Throwable {
        //利用cglib生产代理对象
        return methodProxy.invoke(target,arguments);
    }
}
