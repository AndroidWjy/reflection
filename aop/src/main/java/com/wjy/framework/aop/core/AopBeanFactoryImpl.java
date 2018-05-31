package com.wjy.framework.aop.core;

import com.wjy.framework.aop.adapter.AfterRunningAdviceAdapter;
import com.wjy.framework.aop.adapter.BeforeMethodAdviceAdapter;
import com.wjy.framework.aop.advisor.*;
import com.wjy.framework.aop.bean.AopBeanDefinition;
import com.wjy.framework.aop.interceptor.AopMethodInterceptor;
import com.wjy.framework.ioc.core.BeanFactoryImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实例化json中的对象
 * @author wjy
 */
public class AopBeanFactoryImpl extends BeanFactoryImpl {

    private static final ConcurrentHashMap<String, AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, Object> aopBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {

        Object aopBean = aopBeanMap.get(name);

        if (aopBean != null) {
            return aopBean;
        }

        if (aopBeanDefinitionMap.containsKey(name)) {
            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
            //构造AdvisedSupport数据结构
            AdvisedSupport advisedSupport = getAdvisedSupport(aopBeanDefinition);
            //实例化AOP代理
            aopBean = new CglibAopProxy(advisedSupport).getProxy();
            aopBeanMap.put(name, aopBean);
            return aopBean;
        }

        return super.getBean(name);
    }

    protected void registerBean(String name, AopBeanDefinition aopBeanDefinition) {
        aopBeanDefinitionMap.put(name, aopBeanDefinition);
    }

    /**
     * 实例化advisedSupport
     */
    private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {

        AdvisedSupport advisedSupport = new AdvisedSupport();
        //拿到拦截器列表
        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();
        if (interceptorNames != null && !interceptorNames.isEmpty()) {
            for (String interceptorName : interceptorNames) {
                //实例化切面行为
                Advice advice = (Advice) getBean(interceptorName);

                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);

                if (advice instanceof BeforeMethodAdvice) {
                    //通过适配器将advice转化为interceptor
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

                if (advice instanceof AfterRunningAdvice) {
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

            }
        }

        TargetSource targetSource = new TargetSource();
        //对哪个资源进行加强
        Object object = getBean(aopBeanDefinition.getTarget());

        targetSource.setTargetClass(object.getClass());
        targetSource.setTargetObject(object);

        advisedSupport.setTargetSource(targetSource);


        return advisedSupport;

    }

}
