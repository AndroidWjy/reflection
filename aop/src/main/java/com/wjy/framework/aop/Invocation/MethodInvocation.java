package com.wjy.framework.aop.Invocation;

import java.lang.reflect.Method;

/**
 * 用于描述方法的调用
 * @author wjy
 */

public interface MethodInvocation {
    /**
     * 获取方法
     * @return
     */
    Method getMethod();

    /**
     * 获取参数
     * @return
     */
    Object[] getArguments();

    /**
     * 执行方法本身
     * @return
     * @throws Throwable
     */
    Object proceed() throws Throwable;

}
