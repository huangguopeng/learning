package org.hgp.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hgp on 2017/3/21.
 */
public class UserServiceTest {
    static UserService userService;

    @BeforeClass
    public static void before() throws IOException {
        // 从 XML 中构建 SqlSessionFactory
        String resource = "org/hgp/mybatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userService = new UserService(sqlSessionFactory);

    }

    @Test
    public void save() throws Exception {

        User user = new User();
        user.setName("李四");
        user.setAge(20);
        user.setSex("女");
        user.setBirthday(new Date());
        user.setCreateTime(new Date());
        Assert.assertEquals(userService.save(user), 1);
    }

    @Test
    public void delete() {
        userService.delete(3);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(5);
        user.setName("李四");
        user.setAge(20);
        user.setSex("女");
//        user.setBirthday(new Date());

        Assert.assertEquals(userService.update(user), 1);
    }

    @Test
    public void query() throws Exception {

        User user = userService.query(2);
        System.out.println(user);
//        Assert.assertNotNull(user);
    }

    @Test
    public void query1() throws Exception {
        List<User> users = userService.query(null);
        System.out.println(users);
        Assert.assertTrue(users.size() > 0);
        long startTime = System.currentTimeMillis();

        User user = new User();
        user.setName("李");
        List<User> users1 = userService.query(user);
        System.out.println(users1);
        Assert.assertTrue(users.size() > 0);

        System.out.println("耗时:" + (System.currentTimeMillis() - startTime) + " ms");

    }

}
