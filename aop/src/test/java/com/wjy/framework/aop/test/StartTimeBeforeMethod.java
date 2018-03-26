package com.wjy.framework.aop.test;

import com.wjy.framework.aop.advisor.BeforeMethodAdvice;

import java.lang.reflect.Method;

public class StartTimeBeforeMethod implements BeforeMethodAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始计时");
        ThreadLocalUtils.set(startTime);
    }
}
