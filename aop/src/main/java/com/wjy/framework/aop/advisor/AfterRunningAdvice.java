package com.wjy.framework.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author wjy
 */
public interface AfterRunningAdvice extends Advice{
    Object after(Object returnVal,Method method, Object[] args, Object target);
}
