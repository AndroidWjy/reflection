package com.wjy.framework.aop.bean;

import com.wjy.framework.ioc.bean.BeanDefinition;
import lombok.Data;

import java.util.List;

/**
 * 类似IOC的数据结构，对应json里面属性
 * @author wjy
 */
@Data
public class AopBeanDefinition extends BeanDefinition {

    private String target;

    private List<String> interceptorNames;

}
