package org.hgp.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by hgp on 2017/3/21.
 */
public class UserService {

    private SqlSessionFactory sqlSessionFactory;

    public UserService() {
        // 从 XML 中构建 SqlSessionFactory
        String resource = "org/hgp/mybatis/config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException("mybatis初始化失败");
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public UserService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public int save(User user) {
        SqlSession session = sqlSessionFactory.openSession(true);
        int ret = 0;
        try {
            ret = session.insert("org.hgp.mybatis.User.insertUser", user);
        } finally {
            session.close();
        }

        return ret;
    }

    public int delete(int id) {
        SqlSession session = sqlSessionFactory.openSession(true);
        int ret = 0;
        try {
            ret = session.delete("org.hgp.mybatis.User.deleteUser", id);
        } finally {
            session.close();
        }

        return ret;
    }

    public int update(User user) {
        SqlSession session = sqlSessionFactory.openSession(true);
        int ret = 0;
        try {
            ret = session.update("org.hgp.mybatis.User.updateUser", user);
        } finally {
            session.close();
        }

        return ret;
    }


    public User query(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = session.selectOne("org.hgp.mybatis.User.selectUser", id);
            return user;
        } finally {
            session.close();
        }
    }

    public List<User> query(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<User> users = session.selectList("org.hgp.mybatis.User.selectAllUser", user);
            return users;
        } finally {
            session.close();
        }
    }


}
