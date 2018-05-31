package com.wjy.framework.aop.test;

import com.wjy.framework.aop.core.AopApplicationContext;

public class MainTest {

    public static void main(String[] args) throws Exception {

        AopApplicationContext aopApplicationContext = new AopApplicationContext("application.json");
        aopApplicationContext.init();

        TestService testService = (TestService) aopApplicationContext.getBean("testServiceProxy");
        //调用此方法时，会回调织入的拦截器
        testService.testMethod();


    }
}
