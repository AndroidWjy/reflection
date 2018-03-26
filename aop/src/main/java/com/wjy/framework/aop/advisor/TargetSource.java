package com.wjy.framework.aop.advisor;

import lombok.Data;

@Data
public class TargetSource {

    private Class<?> tagetClass;

    private Object tagetObject;

    public Class<?> getTagetClass() {
        return tagetClass;
    }

    public void setTagetClass(Class<?> tagetClass) {
        this.tagetClass = tagetClass;
    }

    public Object getTagetObject() {
        return tagetObject;
    }

    public void setTagetObject(Object tagetObject) {
        this.tagetObject = tagetObject;
    }
}
