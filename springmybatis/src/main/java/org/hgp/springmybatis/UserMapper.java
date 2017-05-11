package org.hgp.springmybatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hgp on 2017/3/21.
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> selectAllUser() ;


}
