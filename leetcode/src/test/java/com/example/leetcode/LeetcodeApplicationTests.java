package com.example.leetcode;

import com.example.leetcode.demos.web.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;


//@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testGenericBeanDefinition() {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.example.leetcode.demos.web.User");
        beanDefinition.setScope("singleton");
        beanDefinition.setInitMethodName("init");
        MutablePropertyValues values = new MutablePropertyValues();
        values.addPropertyValue("name", "zsy");
        values.addPropertyValue("age", 1);
        beanDefinition.setPropertyValues(values);
        AbstractBeanDefinition abstractBeanDefinition = beanDefinition.cloneBeanDefinition();
        System.out.println(beanDefinition);
        System.out.println(abstractBeanDefinition);
        GenericBeanDefinition definition = new GenericBeanDefinition(beanDefinition);
        definition.overrideFrom(beanDefinition);
    }

    @Test
    void testRegistryByAnnotation() {
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
        reader.register(User.class);
        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));
        System.out.println(registry.getBeanDefinition("user"));
    }

    @Test
    void testIntroSpector() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getPropertyType());
            System.out.println(propertyDescriptor.getWriteMethod());
            System.out.println(propertyDescriptor.getReadMethod());
        }
    }

    /**
     *
     */
    @Test
    void testPropertyDescriptor() throws Exception {
        User user = new User();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("age", User.class);
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(user, 18);
        Method readMethod = propertyDescriptor.getReadMethod();
        System.out.println(readMethod.invoke(user));
    }

    @Test
    public void testBeanWrapper() throws Exception {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.example.leetcode.demos.web.User");
        MutablePropertyValues values = new MutablePropertyValues();
        values.addPropertyValue("name", "zhangsan");
        values.addPropertyValue("age", 1);
        beanDefinition.setPropertyValues(values);

        Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(clazz);
        beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
        System.out.println(beanWrapper.getRootInstance());
        System.out.println(beanWrapper.getWrappedInstance());
    }

    private Map<String, Integer> map = new HashMap<>(8);

    @Test
    void testResolvableType() throws NoSuchFieldException {
        ResolvableType type = ResolvableType.forField(getClass().getDeclaredField("map"));
        System.out.println(type.getType());
        System.out.println(type.getGeneric(0));
        System.out.println(type.getGeneric(1));


    }

    @Test
    public void testPathResource() throws IOException {
        Resource resource = new ClassPathResource("bean.xml");
        InputStream inputStream = resource.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) > -1) {
            System.out.println(new String(buf, 0, len));
        }
    }

    @Test
    void testEnvironment() {
        ApplicationContext context = new GenericApplicationContext();
        Environment env = context.getEnvironment();
        System.out.println(env.getProperty("JAVA_HOME"));
    }


    @Test
    void test() {
        Thread.yield();
    }
}
