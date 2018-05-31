package com.wjy.framework.aop.core;

import com.wjy.framework.aop.advisor.AdvisedSupport;
import com.wjy.framework.ioc.utils.ClassUtils;
import lombok.Data;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * 核心代码
 * @author wjy
 */
@Data
public class CglibAopProxy implements AopProxy{
    /**
     * 引入AOP能够识别的数据结构
     */
    private AdvisedSupport advised;
    /**
     * 构造参数
     */
    private Object[] constructorArgs;
    /**
     * 构造参数类型
     */
    private Class<?>[] constructorArgTypes;

    public CglibAopProxy(AdvisedSupport config){
        this.advised = config;
    }



    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        //拿到class对象
        Class<?> rootClass = advised.getTargetSource().getTargetClass();

        if(classLoader == null){
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        //实例化cglib对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootClass.getSuperclass());



        //增加拦截器的核心方法
        Callback callbacks = getCallBack(advised);
        //设置回调，会执行方法
        enhancer.setCallback(callbacks);
        enhancer.setClassLoader(classLoader);
        if(constructorArgs != null && constructorArgs.length > 0){
            return enhancer.create(constructorArgTypes,constructorArgs);
        }

        return enhancer.create();
    }
    private Callback getCallBack(AdvisedSupport advised) {
        //AOP拦截器
        return new DynamicAdvisedInterceptor(advised.getList(),advised.getTargetSource());
    }
}
