package com.wjy.framework.aop.adapter;

import com.wjy.framework.aop.advisor.Advisor;
import com.wjy.framework.aop.advisor.AfterRunningAdvice;
import com.wjy.framework.aop.interceptor.AfterRunningAdviceInterceptor;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;

public class AfterRunningAdviceAdapter implements AdviceAdapter{

    private AfterRunningAdviceAdapter(){

    }

    private static final AfterRunningAdviceAdapter INSTANTS = new AfterRunningAdviceAdapter();

    public static AfterRunningAdviceAdapter getInstants(){
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
