package org.hgp.springmybatis;

import java.util.List;

/**
 * mybatis扫描时候会自动找同级目录下的 User1Mapper.xml文件，xml文件的命名空间要问该 接口 带包名的类名
 */
public interface User1Mapper {
    List<User> selectAllUser(User user) ;
}
