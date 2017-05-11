package org.hgp.springmybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hgp on 2017/3/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-jdbc.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void query1() {
        User user = new User();
        user.setName("李");
        List<User> users = userService.query(user);
        System.out.println(users);
        Assert.assertTrue(users.size() > 0);
    }

}
