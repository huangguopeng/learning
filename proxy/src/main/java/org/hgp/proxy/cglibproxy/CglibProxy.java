package org.hgp.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理，
 * cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * @param proxy       代理对象
     * @param method      方法
     * @param args        参数
     * @param methodProxy 代理方法类
     * @return 执行方法后的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(proxy.getClass());
        System.out.println(method);
        System.out.println(args);
        System.out.println(methodProxy.getClass());

        Method[] m = methodProxy.getClass().getMethods();
        for (Method a : m)
            System.out.println(a.getName());

        Object result = null;
        System.out.println("做事之前，准备点什么");
        //执行方法
        result = methodProxy.invokeSuper(proxy, args);
        System.out.println("做事之后，收拾一下");
        return result;

    }
}
