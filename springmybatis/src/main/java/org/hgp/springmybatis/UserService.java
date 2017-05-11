package org.hgp.springmybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 简单实例，没得实现什么接口了
 */
@Service
public class UserService {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private User1Mapper userMapper;


//    public int save(User user) {
//    }
//
//    public int delete(int id) {
//    }
//
//    public int update(User user) {
//    }
//
//
//    public User query(int id) {
//    }

    public List<User> query(User user) {
        return userMapper.selectAllUser(user);
    }


}
