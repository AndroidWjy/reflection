package com.wjy.framework.aop.adapter;

import com.wjy.framework.aop.advisor.Advisor;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;

/**
 * 适配器，将advisor适配为interceptor
 * @author wjy
 */
public interface AdviceAdapter {
    /**
     * 拿到Interceptor对象
     * @param advisor
     * @return
     */
    AopMethodInterceptor getInterceptor(Advisor advisor);
}
