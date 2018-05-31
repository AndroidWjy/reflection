package com.wjy.framework.aop.core;

/**
 * @author wjy
 * AOP代理
 */
public interface AopProxy {
    /**
     * 获取代理
     * @return
     */
    Object getProxy();

    /**
     * 带入参获取代理
     * @param classLoader
     * @return
     */
    Object getProxy(ClassLoader classLoader);

}
