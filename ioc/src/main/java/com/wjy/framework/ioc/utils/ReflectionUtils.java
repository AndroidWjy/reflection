package com.wjy.framework.ioc.utils;

import java.lang.reflect.Field;

/**
 * @author wjy
 */
public class ReflectionUtils {
    /**
     * 访问成员变量
     * @param field
     * @param obj
     * @param value
     * @throws IllegalAccessException
     */
    public static void injectField(Field field,Object obj,Object value) throws IllegalAccessException {
        if(field != null) {
            field.setAccessible(true);
            field.set(obj, value);
        }
    }
}
