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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String[] getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String[] interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public List<PropertyArg> getPropertyArgs() {
        return propertyArgs;
    }

    public void setPropertyArgs(List<PropertyArg> propertyArgs) {
        this.propertyArgs = propertyArgs;
    }
}
