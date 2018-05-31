package com.wjy.framework.aop.advisor;

import com.wjy.framework.aop.interceptor.AopMethodInterceptor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 针对哪个目标，增加哪些拦截器
 * @author wjy
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AdvisedSupport extends Advisor {
    /**
     * 目标对象
     */
    private TargetSource targetSource;
    /**
     * 拦截器列表
     */
    private List<AopMethodInterceptor> list = new LinkedList<>();

    public void addAopMethodInterceptor(AopMethodInterceptor interceptor){
        list.add(interceptor);
    }

    public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors){
        list.addAll(interceptors);
    }
}
