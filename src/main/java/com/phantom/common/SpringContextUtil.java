package com.phantom.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-common
 * util
 * com.phantom.util.common.SpringContextUtil
 * 2017-05-08 11:44
 * 提供非spring实现的代码调用spring容器中的Bean功能
 */
@Component
public class SpringContextUtil implements ApplicationContextAware{
    //spring上下文
    private static ApplicationContext applicationContext;

    /**
     * 当实现ApplicationContextAware接口,那么程序在调用getBean(String name)时自动调用该方法
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 根据Bean id名字获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException{
        return applicationContext.getBean(name);
    }

    /**
     * 根据Bean类型获取spring管理的bean
     * @param c
     * @return
     * @throws BeansException
     */
    public static Object getBean(Class<?> c)throws BeansException{
        return applicationContext.getBean(c);
    }

    /**
     * 根据bean id获取相应类型的bean
     * @param name
     * @param requireType
     * @return
     */
    public static Object getBean(String name,Class<?> requireType)throws BeansException{
        return applicationContext.getBean(name,requireType);
    }

    /**
     * 如果BeanFactory包含一个与给定的name匹配的bean则返回true
     * @param name
     * @return
     */
    public static boolean containsBean(String name){
        return applicationContext.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name)throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /**
     * 注册对象的类型
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     * @param name
     * @return
     */
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException{
        return applicationContext.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     * @param name
     * @return
     */
    public static String[] getAliases(String name){
        return applicationContext.getAliases(name);
    }
}
