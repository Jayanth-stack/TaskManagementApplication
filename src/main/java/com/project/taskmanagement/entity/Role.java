package com.project.taskmanagement.entity;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "Role")
public class Role {

    @Id
    private long id;


    @Field("Role_name")
    private RoleName name;

    public Role() {

    }
    public Role(RoleName name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
