package com.wjy.framework.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author wjy
 */
public interface BeforeMethodAdvice extends Advice{
    /**
     * 执行之前
     * @param method
     * @param args
     * @param target
     */
    void before(Method method, Object[] args, Object target);
}
