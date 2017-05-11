package org.hgp.proxy.jdkproxy;

import org.hgp.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk代理的缺点，被代理的类一定要实现某些接口，代理的实习主要在事务处理器(InvocationHandler)
 */
public class JdkProxy {

    public static Object createInstance(Object o) {
        InvocationHandler handler = new Handler(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), handler);

    }


}
