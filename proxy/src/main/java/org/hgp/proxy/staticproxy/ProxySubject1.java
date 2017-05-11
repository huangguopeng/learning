package org.hgp.proxy.staticproxy;

import org.hgp.proxy.RealSubject;

/**
 * 第一种代理方式：继承
 */
public class ProxySubject1 extends RealSubject {

    @Override
    public void doSomeThing() {
        System.out.println("做事之前，准备点什么");
        super.doSomeThing();
        System.out.println("做事之后，收拾一下");
    }

}
