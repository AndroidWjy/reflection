package com.wjy.framework.aop.Invocation;

/**
 * 代理方法的调用
 */

public interface ProxyMethodInvocation extends MethodInvocation {

    Object getProxy();

}
