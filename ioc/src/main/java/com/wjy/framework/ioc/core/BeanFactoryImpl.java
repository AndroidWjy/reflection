package com.wjy.framework.ioc.core;

import com.wjy.framework.ioc.bean.BeanDefinition;
import com.wjy.framework.ioc.bean.ConstructorArg;
import com.wjy.framework.ioc.utils.BeanUtils;
import com.wjy.framework.ioc.utils.ClassUtils;
import com.wjy.framework.ioc.utils.ReflectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wjy
 */
public class BeanFactoryImpl implements BeanFactory {
    /**
     * 存储对象名与对象的映射关系
     */
    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();
    /**
     * 存储对象名与对象对应构造方法和数据的映射关系
     */
    private static final ConcurrentHashMap<String, BeanDefinition> beanDefineMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());
    /**
     * 构造方法支持的基本类型
     */
    private static final Map<String, Class> map = new HashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        //查找对象是否已经实例化过
        Object bean = beanMap.get(name);
        if (bean != null) {
            return bean;
        }
        //如果没有实例化，那就需要调用createBean来创建对象
        bean = createBean(beanDefineMap.get(name));

        if (bean != null) {
            //对象创建成功以后，注入对象需要的参数
            populateBean(bean);
            //再吧对象存入Map中方便下次使用。
            beanMap.put(name, bean);
        }
        //结束返回
        return bean;
    }

    static {
        map.put("String", String.class);
        map.put("Integer", Integer.class);
        map.put("Long", Long.class);
        map.put("Float", Float.class);
    }

    protected void registerBean(String name, BeanDefinition bd) {
        beanDefineMap.put(name, bd);
        beanNameSet.add(name);
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        if (beanDefinition == null) {
            return null;
        }
        String beanName = beanDefinition.getClassName();
        //类加载器拿到类
        Class clz = ClassUtils.loadClass(beanName);
        if (clz == null) {
            throw new Exception("can not find bean by beanName");
        }
        //构造参数
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            Class[] classes = new Class[constructorArgs.size()];
            List<Object> objects = new ArrayList<>();
            int count = 0;
            for (ConstructorArg constructorArg : constructorArgs) {
                //递归的拿到构造参数
                objects.add(constructorArg.getRef());
                String type = constructorArg.getType();
                //必须写类型
                classes[count] = map.get(type);
                count++;
            }
            return BeanUtils.instanceByCglib(clz, clz.getConstructor(classes), objects.toArray());
        } else {
            return BeanUtils.instanceByCglib(clz, null, null);
        }
    }

    /**
     * 将参数注入到对象
     *
     * @param bean
     * @throws Exception
     */
    private void populateBean(Object bean) throws Exception {
        //反射拿到对象中的变量
        Field[] fields = bean.getClass().getSuperclass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                //bean下面的参数
                String beanName = field.getName();
                beanName = StringUtils.uncapitalize(beanName);
                //递归的给对象参数赋值
                if (beanNameSet.contains(field.getName())) {
                    Object fieldBean = getBean(beanName);
                    if (fieldBean != null) {
                        ReflectionUtils.injectField(field, bean, fieldBean);
                    }
                }
            }
        }
    }
}
