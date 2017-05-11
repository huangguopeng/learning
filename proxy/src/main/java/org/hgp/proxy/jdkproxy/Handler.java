package org.hgp.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hgp on 2017/3/19.
 */
public class Handler implements InvocationHandler {

    private Object target;

    public Handler(Object target) {
        super();
        this.target = target;
    }

    /**
     * @param proxy  被代理对象
     * @param method 要调用方法
     * @param args   函数
     * @return 执行方法后的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getCanonicalName());
        System.out.println(method);
        System.out.println(args);

        Object result = null;
        System.out.println("做事之前，准备点什么");
        //执行方法
        result = method.invoke(target, args);
        System.out.println("做事之后，收拾一下");
        return result;

    }
}
