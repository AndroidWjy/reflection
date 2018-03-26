package com.wjy.framework.ioc.testjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wjy
 */
public class UserServiceProxy implements InvocationHandler {
    /**
     * 业务实现类对象
     */
    private Object target;

    public UserServiceProxy() {
        super();
    }

    public UserServiceProxy(Object target) {
        super();
        this.target = target;
    }

    public Object bind() {
        //创建代理类，通过反射，参数类加载器、接口以及handler实现类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("预处理");
        result = method.invoke(target, args);
        System.out.println("调用完成");
        return result;
    }
}
