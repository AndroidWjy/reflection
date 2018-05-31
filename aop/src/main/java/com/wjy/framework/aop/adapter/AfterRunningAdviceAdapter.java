package com.wjy.framework.aop.adapter;

import com.wjy.framework.aop.advisor.Advisor;
import com.wjy.framework.aop.advisor.AfterRunningAdvice;
import com.wjy.framework.aop.interceptor.AfterRunningAdviceInterceptor;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;

/**
 * 后置适配器
 * @author wjy
 */
public class AfterRunningAdviceAdapter implements AdviceAdapter{

    private AfterRunningAdviceAdapter(){

    }

    private static final AfterRunningAdviceAdapter INSTANTS = new AfterRunningAdviceAdapter();

    public static AfterRunningAdviceAdapter getInstants(){
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        //将advisor适配成拦截器
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        //实例化
        return new AfterRunningAdviceInterceptor(advice);
    }
}
