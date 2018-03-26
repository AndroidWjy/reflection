package com.wjy.framework.ioc.entity;

public class Mouth {
    private String apple;

    public Mouth(String apple) {
        this.apple = apple;
    }

    public void speak() {

        System.out.println(this.apple);

    }

}
