package com.wjy.framework.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author wjy
 */
public interface AfterRunningAdvice extends Advice{
    /**
     * 执行之后
     * @param returnVal
     * @param method
     * @param args
     * @param target
     * @return
     */
    Object after(Object returnVal,Method method, Object[] args, Object target);
}
