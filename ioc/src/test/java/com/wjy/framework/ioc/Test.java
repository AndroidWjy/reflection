package com.wjy.framework.ioc;

import com.wjy.framework.ioc.core.JsonApplicationContext;
import com.wjy.framework.ioc.entity.Robot;

public class Test {

    public static void main(String[] args) throws Exception {

        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");

        aiRobot.show();

    }


}
