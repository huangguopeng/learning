package org.hgp.proxy.staticproxy;

import org.hgp.proxy.Subject;

/**
 * 第二种代理方式：聚合(推荐使用)
 */
public class ProxySubject2 implements Subject {
    private Subject subject;

    public ProxySubject2(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doSomeThing() {
        System.out.println("做事之前，准备点什么");
        subject.doSomeThing();
        System.out.println("做事之后，收拾一下");
    }

    @Override
    public void doSomeThing(String someThing) {
        System.out.println("做事之前，准备点什么");
        subject.doSomeThing(someThing);
        System.out.println("做事之后，收拾一下");
    }
}
