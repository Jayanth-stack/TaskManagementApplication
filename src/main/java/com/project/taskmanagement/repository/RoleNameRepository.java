package com.project.taskmanagement.repository;
import com.project.taskmanagement.entity.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleNameRepository extends MongoRepository<RoleName, String> {

}
