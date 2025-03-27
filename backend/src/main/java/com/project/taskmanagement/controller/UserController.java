package com.project.taskmanagement.controller;


import com.project.taskmanagement.resource.UserListResource;
import com.project.taskmanagement.resource.UserResource;
import com.project.taskmanagement.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserListResource> getAllUser() {
        UserListResource ulr = new UserListResource();
        ulr.setUsers(userService.getAllUser());
        return new ResponseEntity<UserListResource>(ulr, HttpStatus.OK);
    }

    @GetMapping("/getAllUser/{pid}")
    public ResponseEntity<UserListResource> getAllUser(@PathVariable("pid") Long pid) {
        UserListResource ulr = new UserListResource();
        ulr.setUsers(userService.getAllUserByProgram(pid));
        return new ResponseEntity<UserListResource>(ulr, HttpStatus.OK);
    }

    @GetMapping("/getUser/{uid}")
    public ResponseEntity<UserResource> getUserById(@PathVariable("uid") Long uid) {
        UserResource ur = new UserResource();
        BeanUtils.copyProperties(userService.getUser(uid), ur);
        return new ResponseEntity<UserResource>(ur, HttpStatus.OK);
    }

}
