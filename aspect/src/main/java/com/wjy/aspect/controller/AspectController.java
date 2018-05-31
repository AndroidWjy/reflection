package com.wjy.aspect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjinyang@g7.com.cn
 */
@RestController
@RequestMapping("/aspect")
public class AspectController {

    @RequestMapping(value = "/testBefore", method = {RequestMethod.GET})
    public String testBeforeService(String key, String value) {
        System.out.println("======执行本身方法=====");
        return "key=" + key + " value=" + value;
    }

    /**
     * 不同的参数
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/testAfterRunning", method = {RequestMethod.GET})
    public String testAfterRunning(String key) {
        return "key=" + key;
    }

    @RequestMapping(value = "/testAfterRunningWith", method = {RequestMethod.GET})
    public Integer testAfterRunning(Integer key) {
        return key;
    }

    @RequestMapping(value = "/testException", method = {RequestMethod.GET})
    public String testException() {
        //直接抛出异常
        throw new NullPointerException();
    }

    @RequestMapping(value = "/testAround", method = {RequestMethod.GET})
    public String testAroundService(String key) {
        System.out.println("======执行本身方法=====");
        return "环绕通知：" + key;
    }

    @RequestMapping(value = "/testAfter", method = {RequestMethod.GET})
    public String testAfter(String key) {

        return key;
    }
}
