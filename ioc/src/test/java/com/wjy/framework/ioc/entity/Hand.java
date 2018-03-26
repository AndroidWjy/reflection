package com.wjy.framework.ioc.entity;

public class Hand {

    private Integer left;

    private Integer right;


    public Hand(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    public void waveHand() {

        //System.out.println("挥一挥手");
        System.out.println(this.left + this.right);

    }

}
