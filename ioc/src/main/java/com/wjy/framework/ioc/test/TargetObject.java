package com.wjy.framework.ioc.test;

/**
 * @author wjy
 */
public class TargetObject {
    private String name = "wjy";
    private int age = 24;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String setSex(String sex) {
        return sex;
    }

    @Override
    public String toString() {
        return "TargetObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
