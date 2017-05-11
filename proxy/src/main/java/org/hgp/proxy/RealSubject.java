package org.hgp.proxy;

/**
 * 实现接口
 */
public class RealSubject implements Subject {

    @Override
    public void doSomeThing() {
        System.out.println("做点什么事情");
    }

    @Override
    public void doSomeThing(String someThing) {
        System.out.println(someThing);
    }
}
