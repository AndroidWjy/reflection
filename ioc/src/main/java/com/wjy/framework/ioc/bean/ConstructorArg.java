package com.wjy.framework.ioc.bean;


import lombok.Data;
import lombok.ToString;

/**
 * @author wjy
 * 构造函数参数
 */
@Data
@ToString
public class ConstructorArg {

    private int index;
    private Object ref;
    private String name;

    private String type;

}
