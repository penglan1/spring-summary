package pers.penglan.ioc.extension.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import pers.penglan.ioc.entity.extension.Lifecycle;

/**
 * BeanPostProcessor处理器
 *
 * @Author PENGL
 * 2020-03-03
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + beanName);
        if ("lifecycle".equals(beanName)) {
            Lifecycle lifecycle = (Lifecycle) bean;
            lifecycle.setName("马超...被再次设置");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + beanName);
        return bean;
    }
}
