package com.wjy.framework.aop.Invocation;

import java.lang.reflect.Method;

/**
 * 用于描述方法的调用
 * @author wjy
 */

public interface MethodInvocation {

    Method getMethod();

    Object[] getArguments();

    Object proceed() throws Throwable;

}
