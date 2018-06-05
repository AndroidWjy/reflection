package com.wjy.framework.ioc.testjdk;

import java.lang.reflect.Method;

/**
 * @author wjy
 */
public class TestJdk {
    public static void main(String[] args) {
//        UserServiceImpl userServiceImpl = new UserServiceImpl();
//        //代理类
//        UserServiceProxy userServiceProxy = new UserServiceProxy(userServiceImpl);
//        UserService userService = (UserService) userServiceProxy.bind();
//        System.out.println(userService.getAge(12));
//        System.out.println(userService.getName("wjy"));

        Class<UserServiceImpl> userServiceClass = UserServiceImpl.class;
        Method getName = null;
        try {
            getName = userServiceClass.getMethod("getName", String.class);
            //传入对象必须是实例对象，静态方法直接null
            Object wjy = getName.invoke(new UserServiceImpl(), "wjy");
            System.out.println(wjy);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
