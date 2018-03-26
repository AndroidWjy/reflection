package com.wjy.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;


/**
 * @author wjy
 * IOC框架管理对象
 */
@Data
@ToString
public class BeanDefinition {

    private String name;

    private String className;
    /**
     * 接口对象
     */
    private String[] interfaceName;

    /**
     * 构造函数传参列表
     */
    private List<ConstructorArg> constructorArgs;

    /**
     * 需要注入的参数列表
     */
    private List<PropertyArg> propertyArgs;

}
