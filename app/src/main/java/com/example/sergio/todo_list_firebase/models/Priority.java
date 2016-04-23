package com.example.sergio.todo_list_firebase.models;

/**
 * Created by sergio on 23/04/2016.
 */
public class Priority {

    private int id;
    private String name;
    private String desc;

    public Priority(){}

    public Priority(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
