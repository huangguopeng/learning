package org.hgp.dwr;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import java.util.Collection;

/**
 * Created by hgp on 2017/3/23.
 */
public class MessagePushService {

    public void send(String msg) {
        // 得到上下文
        WebContext context = WebContextFactory.get();

        //得到要推送到 的页面  dwr3为项目名称 ， 一定要加上。
        Collection<ScriptSession> sessions = context.getScriptSessionsByPage("/push.html");

        for (ScriptSession s : sessions) {
            System.out.println(s.toString());
        }

        //不知道该怎么解释这个 ，
        Util util = new Util(sessions);

        //下面是创建一个javascript脚本 ， 相当于在页面脚本中添加了一句  show(msg);
        ScriptBuffer sb = new ScriptBuffer();
        sb.appendScript("show(");
        sb.appendData(msg);
        sb.appendScript(")");

        //推送
        util.addScript(sb);
    }
}
