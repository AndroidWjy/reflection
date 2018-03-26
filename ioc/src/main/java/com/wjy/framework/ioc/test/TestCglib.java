package com.wjy.framework.ioc.test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author wjy
 * 直接生成子类
 * 测试Cglib的方法
 */
public class TestCglib {
    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        //方法回调
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        //拦截器
        Callback callback = new TargetInterceptor();
        //直接调用被代理的方法
        Callback noop = NoOp.INSTANCE;
        Callback fixedValue = new TargetResultFixed();
        //针对每个方法的回调
        Callback[] callbacks = new Callback[]{callback,noop,fixedValue};

        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(callbackFilter);

        TargetObject targetObject = (TargetObject) enhancer.create();

        System.out.println(targetObject.getAge());
        System.out.println(targetObject.getName());
        System.out.println(targetObject.setSex("男"));
    }
}
