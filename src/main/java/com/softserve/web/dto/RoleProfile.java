package com.softserve.web.dto;

public class RoleProfile {
    private String name;
    private String description;

    public RoleProfile() {
        name = "";
        description = "";
    }

    public RoleProfile(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoleProfile{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
