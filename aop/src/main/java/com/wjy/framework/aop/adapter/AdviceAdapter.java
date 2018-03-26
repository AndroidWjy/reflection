package com.wjy.framework.aop.adapter;

import com.wjy.framework.aop.advisor.Advisor;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;

public interface AdviceAdapter {

    AopMethodInterceptor getInterceptor(Advisor advisor);
}
