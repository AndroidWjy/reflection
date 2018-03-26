package com.wjy.framework.ioc.core;

import com.wjy.framework.ioc.bean.BeanDefinition;
import com.wjy.framework.ioc.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.List;

/**
 * @author wjy
 */
public class JsonApplicationContext extends BeanFactoryImpl{

    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile(){
        //首先拿到当前线程，类加载器，然后将资源变为流
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        //从json的内容实例化对象
        List<BeanDefinition> beanDefinitions = JsonUtils.readValue(is,new TypeReference<List<BeanDefinition>>(){});
        if(beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (BeanDefinition beanDefinition : beanDefinitions) {
                //注册bean对象
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }

    }


}
