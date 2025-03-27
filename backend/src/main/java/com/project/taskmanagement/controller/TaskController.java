package com.project.taskmanagement.controller;


import com.project.taskmanagement.dto.CodeDTO;
import com.project.taskmanagement.dto.NewProgramDTO;
import com.project.taskmanagement.entity.Program;
import com.project.taskmanagement.resource.ProgramListResource;
import com.project.taskmanagement.service.ProgramService;
import com.project.taskmanagement.service.UserService;
import com.project.taskmanagement.utils.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private UserService userService;

    @GetMapping("/createProgram/{uid}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     public ResponseEntity<Boolean> createProgram(@PathVariable("uid") Long uid, @RequestBody NewProgramDTO programDTO) {
         programService.createProgram(programDTO, uid);
         return new ResponseEntity<Boolean>(true, HttpStatus.OK);

     }

     @GetMapping("/getAllProgram")
     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     public ResponseEntity<ProgramListResource> getAllProgram(){
         return new ResponseEntity<ProgramListResource>(programService.getAll(), HttpStatus.OK);
     }

     @GetMapping("/getAllProgramByAdmin/{id}")
     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     public ResponseEntity<ProgramListResource> getAllProgramByAdmin(@PathVariable("id") Long uid) {
         ProgramListResource dto = programService.getAllByAdmin(uid);
         return new ResponseEntity<ProgramListResource>(dto, HttpStatus.OK);
     }

     @GetMapping("/getAllProgramByUser/{uid}")
     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     public ResponseEntity<ProgramListResource> getAllProgramByUser(@PathVariable("uid") Long uid) {
        ProgramListResource dto = new ProgramListResource();
        dto.setProgramList(userService.getAllProgramByUser(uid));
        return new ResponseEntity<ProgramListResource>(dto, HttpStatus.OK);
     }

     @GetMapping("/enterPrg")
     @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     public ResponseEntity<Boolean> enterProgram(@RequestBody CodeDTO codeDTO){
         programService.addUser(codeDTO.getUid(), codeDTO.getCode());
         return new ResponseEntity<Boolean>(true, HttpStatus.OK);
     }

}
