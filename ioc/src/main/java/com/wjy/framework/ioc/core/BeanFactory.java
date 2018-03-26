package com.wjy.framework.ioc.core;

/**
 * @author wjy
 */
public interface BeanFactory {
    /**
     * 根据名字注入
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;

}
