package com.project.taskmanagement.controller;

import com.project.taskmanagement.entity.Role;
import com.project.taskmanagement.entity.RoleName;
import com.project.taskmanagement.entity.User;
import com.project.taskmanagement.message.request.LoginForm;
import com.project.taskmanagement.message.request.SignUpForm;
import com.project.taskmanagement.message.response.JwtResponse;
import com.project.taskmanagement.repository.RoleRepository;
import com.project.taskmanagement.repository.UserRepository;
import com.project.taskmanagement.security.jwt.JwtProvider;
import com.project.taskmanagement.service.MailService;
import com.project.taskmanagement.utils.Client;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    final String clientUrl = Client.clientUrl;

    @Autowired
    MailService service;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private HttpSession httpSession;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        long id = Long.parseLong(userRepository.getIdByUsername(userDetails.getUsername()));
        JwtResponse jwtRes = new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), id);
        return ResponseEntity.ok(jwtRes);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

        if(signUpRequest.getUser().equalsIgnoreCase("U")){
            Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Role Not Found"));
            roles.add(userRole);
        }else if(signUpRequest.getUser().equalsIgnoreCase("A")){
            Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role Not Found"));
            roles.add(adminRole);
        }

        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }



}
