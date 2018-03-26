package com.wjy.framework.ioc.utils;

/**
 * @author wjy
 */
public class ClassUtils {

    private static ClassLoader getDefaultClassLoader(){
        //拿到当前类加载器
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 通过className获取对象class
     * @param className
     * @return
     */
    public static Class loadClass(String className){
        try {
            return getDefaultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
