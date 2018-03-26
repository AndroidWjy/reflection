package com.wjy.framework.aop.adapter;

import com.wjy.framework.aop.advisor.Advisor;
import com.wjy.framework.aop.advisor.BeforeMethodAdvice;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;
import com.wjy.framework.aop.interceptor.BeforeMethodAdviceInterceptor;

public class BeforeMethodAdviceAdapter implements AdviceAdapter{

    private BeforeMethodAdviceAdapter() {
    }

    private static final BeforeMethodAdviceAdapter INSTANTS = new BeforeMethodAdviceAdapter();

    public static BeforeMethodAdviceAdapter getInstants(){
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
        return new BeforeMethodAdviceInterceptor(advice);
    }
}
