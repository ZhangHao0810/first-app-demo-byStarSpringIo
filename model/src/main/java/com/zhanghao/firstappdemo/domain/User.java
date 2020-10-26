package com.zhanghao.firstappdemo.domain;

/**
 *  用户模型
 */
public class User {

    //用户id
    private int id;

    //用户名
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写 toString，方便调试，看对象的内容。
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
