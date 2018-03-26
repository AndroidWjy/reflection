package com.wjy.framework.aop.bean;

import com.wjy.framework.ioc.bean.BeanDefinition;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class AopBeanDefinition extends BeanDefinition{

    private String target;

    private List<String> interceptorNames;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<String> getInterceptorNames() {
        return interceptorNames;
    }

    public void setInterceptorNames(List<String> interceptorNames) {
        this.interceptorNames = interceptorNames;
    }

}
