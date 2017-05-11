package org.hgp;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {

    // 静态编译
    @org.junit.Test
    public void testGroovyClass() {
        HumanBean humanBean = new HumanBean();
        humanBean.setName("张三");
        humanBean.setAge(10);
        humanBean.setSex("man");
        System.out.println(humanBean);
    }

    @org.junit.Test
    // 通过groovyShell类直接执行脚本
    public void testGroovyShell() {
        Binding bind = new Binding();
        bind.setVariable("str", "test");
        GroovyShell shell = new GroovyShell(bind);
        Object obj = shell.evaluate("return str");
        System.out.println(obj);
    }

    @org.junit.Test
    // 通过groovyScriptEngine执行文件或者脚本
    public void testGroovyScript() throws IOException, ResourceException, ScriptException {
        GroovyScriptEngine engine = new GroovyScriptEngine("groovy");
        Object obj = engine.run("src/main/java/org/hgp/Test.groovy","test");
        System.out.println(obj);
    }

    @org.junit.Test
    //通过GroovyClassLoader来执行
    public void testGroovyClassLoader() throws IllegalAccessException, InstantiationException, IOException {
        String script="src/main/java/org/hgp/YellowHuman.groovy";//groovy script
        ClassLoader parent = ClassLoader.getSystemClassLoader();
        GroovyClassLoader loader = new GroovyClassLoader(parent);
        Class< ?> clazz = loader.parseClass(new File(script));
        GroovyObject clazzObj = (GroovyObject)clazz.newInstance();
        clazzObj.invokeMethod("say", "你好吗");
//        Human human = (Human) clazz.newInstance();
//        human.say("hello ");
    }

}
