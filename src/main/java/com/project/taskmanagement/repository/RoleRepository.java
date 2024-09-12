package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

}
