package com.wjy.framework.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author wjy
 */
public interface BeforeMethodAdvice extends Advice{
    void before(Method method, Object[] args, Object target);
}
