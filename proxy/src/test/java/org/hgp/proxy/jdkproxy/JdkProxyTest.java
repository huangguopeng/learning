package org.hgp.proxy.jdkproxy;

import org.hgp.proxy.RealSubject;
import org.hgp.proxy.Subject;
import org.junit.Test;

/**
 * Created by hgp on 2017/3/20.
 */
public class JdkProxyTest {

    @Test
    public void proxy() {
        RealSubject realSubject = new RealSubject();
        Subject subject = (Subject) JdkProxy.createInstance(realSubject);

        subject.doSomeThing();
        subject.doSomeThing("做坏事");

    }

}