package com.project.taskmanagement.controller;

import com.project.taskmanagement.service.ProgramService;
import com.project.taskmanagement.service.UserService;
import com.project.taskmanagement.utils.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProgramController {

    final String clientUrl = Client.clientUrl;

    @Autowired
    private ProgramService service;

    @Autowired
    private UserService userService;


}
