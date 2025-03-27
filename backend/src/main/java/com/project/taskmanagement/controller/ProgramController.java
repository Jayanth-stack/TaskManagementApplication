package com.project.taskmanagement.controller;

import com.project.taskmanagement.dto.CodeDTO;
import com.project.taskmanagement.dto.NewProgramDTO;
import com.project.taskmanagement.resource.ProgramListResource;
import com.project.taskmanagement.service.ProgramService;
import com.project.taskmanagement.service.UserService;
import com.project.taskmanagement.utils.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProgramController {

    final String clientUrl = Client.clientUrl;

    @Autowired
    private ProgramService service;

    @Autowired
    private UserService userService;

    @PostMapping("/createProgram/{uid}")
    @PreAuthorize("hasRole('User') or hasRole('Admin')")
    public ResponseEntity<Boolean> createProgram(@PathVariable("uid") Long uid, @RequestBody NewProgramDTO newProgramDTO) {
        service.createProgram(newProgramDTO, uid);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getAllProgram")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') ")
    public ResponseEntity<ProgramListResource> getAllPrograms() {
        return new ResponseEntity<ProgramListResource>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllProgramByAdmin/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ProgramListResource> getAllProgramByAdmin(@PathVariable("uid") Long uid) {
        ProgramListResource dto = service.getAllByAdmin(uid);
        return new ResponseEntity<ProgramListResource>(dto, HttpStatus.OK);
    }

    @GetMapping("getAllProgramByUser/{uid}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ProgramListResource> getAllProgramByUser(@PathVariable("uid") Long uid) {
        ProgramListResource dto = new ProgramListResource();
        dto.setProgramList(userService.getAllProgramByUser(uid));
        return new ResponseEntity<ProgramListResource>(dto, HttpStatus.OK);
    }

    @GetMapping("/enterPrg")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Boolean> enterProgram(@RequestBody CodeDTO code){
        service.addUser(code.getUid(), code.getCode());
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


}
