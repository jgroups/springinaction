package me.lbing.rmi;

import java.io.Serializable;

/**
 * Created by King on 2016/6/3.
 */
public class PersonEntity implements Serializable {
    private int id;
    private String name;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
