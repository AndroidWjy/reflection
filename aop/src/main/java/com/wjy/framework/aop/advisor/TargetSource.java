package com.wjy.framework.aop.advisor;

import lombok.Data;

/**
 * @author wjy
 */
@Data
public class TargetSource {

    private Class<?> targetClass;

    private Object targetObject;
}
