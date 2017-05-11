package org.hgp.proxy.cglibproxy;

import org.hgp.proxy.RealSubject;
import org.hgp.proxy.Subject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hgp on 2017/3/20.
 */
public class CglibProxyTest {

    @Test
    public void proxy() {
        RealSubject realSubject = new RealSubject();
        Subject subject = (Subject) new CglibProxy().getInstance(realSubject);
        subject.doSomeThing();
        subject.doSomeThing("做坏事");
    }

}