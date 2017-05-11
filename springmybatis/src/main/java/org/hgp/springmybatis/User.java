package org.hgp.springmybatis;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hgp on 2017/3/21.
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private String sex;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", birthday=" + birthday +
            ", sex='" + sex + '\'' +
            ", createTime=" + createTime +
            '}';
    }
}
