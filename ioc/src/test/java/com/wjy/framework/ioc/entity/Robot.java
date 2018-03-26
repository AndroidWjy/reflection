package com.wjy.framework.ioc.entity;

import lombok.Data;

@Data
public class Robot {

    private Hand hand;

    private Mouth mouth;

    public void show(){
        hand.waveHand();
        mouth.speak();
    }

}
