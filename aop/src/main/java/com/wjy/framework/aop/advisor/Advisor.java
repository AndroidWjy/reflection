package com.wjy.framework.aop.advisor;


import lombok.Data;

@Data
public class Advisor {

    private Advice advice;

    private Pointcut pointcut;

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }
}
