package com.project.taskmanagement.resource;

import java.util.List;

public class UserListResource {

    private List<UserResource> users;

    public List<UserResource> getUsers() {
        return users;
    }
    public void setUsers(List<UserResource> users) {
        this.users = users;
    }
}
