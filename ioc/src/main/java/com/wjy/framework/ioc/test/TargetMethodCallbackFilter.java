package com.wjy.framework.ioc.test;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author wjy
 * 回调过滤器的方法，返回的值对应Callback[]的位置索引
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("getName")){
            System.out.println("filter getName == 0");
            return 0;
        }
        if(method.getName().equals("getAge")){
            System.out.println("filter getAge == 1");
            return 1;
        }
        if(method.getName().equals("setSex")){
            System.out.println("filter setSex == 2");
            return 2;
        }
        return 0;
    }
}
