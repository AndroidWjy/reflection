package com.wjy.framework.aop.Invocation;

/**
 * 代理方法的调用
 * @author wjy
 */

public interface ProxyMethodInvocation extends MethodInvocation {
    /**
     * 获取代理对象
     * @return
     */
    Object getProxy();

}
