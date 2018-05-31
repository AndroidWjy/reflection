package com.wjy.framework.aop.advisor;


import lombok.Data;

/**
 * @author wjy
 */
@Data
public class Advisor {
    /**
     * 干什么
     */
    private Advice advice;
    /**
     * 在哪里
     */
    private Pointcut pointcut;

}
