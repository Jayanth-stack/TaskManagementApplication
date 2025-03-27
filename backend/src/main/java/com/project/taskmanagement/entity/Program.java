package com.project.taskmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.List;

@Document(collection = "Program")
public class Program {
    @Id
    private long id;

    @Field("name")
    private String name;
    @Field("Description")
    private String description;

    @DBRef
    private List<User> users;

    private long admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getAdmin() {
        return admin;
    }

    public void setAdmin(long admin) {
        this.admin = admin;
    }
}
