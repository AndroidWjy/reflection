package com.wjy.framework.ioc.testjdk;

public interface UserService {
    /**
     * 获取名字
     * @param name
     * @return
     */
    String getName(String name);

    /**
     * 获取年龄
     * @param id
     * @return
     */
    Integer getAge(int id);
}
