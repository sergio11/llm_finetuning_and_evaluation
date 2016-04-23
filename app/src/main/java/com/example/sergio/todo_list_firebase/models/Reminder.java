package com.example.sergio.todo_list_firebase.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergio on 23/04/2016.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Reminder {

    private int id;
    private String name;
    private String desc;
    private boolean notify;
    private Priority priority;

    public Reminder(){}

    public Reminder(String name, int id, boolean notify, Priority priority, String desc) {
        this.name = name;
        this.id = id;
        this.notify = notify;
        this.priority = priority;
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

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
