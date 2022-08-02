package com.softserve.web.dto;

public class RoleGet {
    private String name;

    public RoleGet() {
        name = "";
    }

    public RoleGet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleGet{" +
                "name='" + name + '\'' +
                '}';
    }
}
