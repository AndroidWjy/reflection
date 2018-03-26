package com.wjy.framework.ioc.testjdk;

/**
 * @author wjy
 */
public class TestJdk {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        //代理类
        UserServiceProxy userServiceProxy = new UserServiceProxy(userServiceImpl);
        UserService userService = (UserService) userServiceProxy.bind();
        System.out.println(userService.getAge(12));
        System.out.println(userService.getName("wjy"));

    }
}
