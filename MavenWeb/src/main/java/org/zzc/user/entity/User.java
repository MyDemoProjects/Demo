package org.zzc.user.entity;

/**
 * 用户信息
 * Created by Administrator on 2015/8/26 0026.
 */
public class User {
    /** primary key */
    private Long id;
    /** name */
    private String name;
    /** age */
    private Integer age;
    /** sex */
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
