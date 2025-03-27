package com.project.taskmanagement.config;

import com.project.taskmanagement.entity.Role;
import com.project.taskmanagement.entity.RoleName;
import com.project.taskmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles if they don't exist
        if (roleRepository.count() == 0) {
            System.out.println("Initializing roles...");
            
            Role userRole = new Role(RoleName.ROLE_USER);
            Role adminRole = new Role(RoleName.ROLE_ADMIN);
            
            roleRepository.save(userRole);
            roleRepository.save(adminRole);
            
            System.out.println("Roles initialized successfully!");
        }
    }
} 