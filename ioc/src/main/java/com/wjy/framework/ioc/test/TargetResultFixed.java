package com.wjy.framework.ioc.test;

import net.sf.cglib.proxy.FixedValue;

/**
 * @author wjy
 * 锁定返回值
 */
public class TargetResultFixed implements FixedValue{
    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果");
        Object obj = "999";
        return obj;
    }
}
