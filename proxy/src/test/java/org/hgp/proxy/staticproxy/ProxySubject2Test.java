package org.hgp.proxy.staticproxy;

import org.hgp.proxy.RealSubject;
import org.hgp.proxy.Subject;

/**
 * Created by hgp on 2017/3/19.
 */
public class ProxySubject2Test {
    @org.junit.Test
    public void doSomeThing() throws Exception {
        Subject subject = new RealSubject();

        ProxySubject2 ps2 = new ProxySubject2(subject);
        ps2.doSomeThing();
    }

}