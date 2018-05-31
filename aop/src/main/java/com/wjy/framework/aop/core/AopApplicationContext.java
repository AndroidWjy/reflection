package com.wjy.framework.aop.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wjy.framework.aop.bean.AopBeanDefinition;
import com.wjy.framework.ioc.bean.BeanDefinition;
import com.wjy.framework.ioc.utils.ClassUtils;
import com.wjy.framework.ioc.utils.JsonUtils;

import java.io.InputStream;
import java.util.List;

/**
 * 上下文对象
 * @author wjy
 */
public class AopApplicationContext extends AopBeanFactoryImpl {

    private String fileName;

    public AopApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile(){
        //获取json文件对象
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is,new TypeReference<List<AopBeanDefinition>>(){});

        if(beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (AopBeanDefinition beanDefinition : beanDefinitions){
                Class<?> clz = ClassUtils.loadClass(beanDefinition.getClassName());
                if(clz == ProxyFactoryBean.class){
                    //若是AOP代理类，注册bean对象
                    registerBean(beanDefinition.getName(),beanDefinition);
                }else {
                    //若是IOC
                    registerBean(beanDefinition.getName(),(BeanDefinition) beanDefinition);
                }
            }
        }

    }


}
