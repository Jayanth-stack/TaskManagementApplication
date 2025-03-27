package com.project.taskmanagement.repository;
import com.project.taskmanagement.entity.Program;
import com.project.taskmanagement.entity.User;
import com.project.taskmanagement.resource.UserResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "{ 'username' : ?0 }", fields = "{ 'id' : 1, '_id' : 0 }")
    String getIdByUsername(String username);

    @Query(value = "{ 'id' : ?0 }", fields = "{ 'program' : 1, '_id' : 0 }")
    List<Program> findProgramById(Long id);

    @Query(value = "{}", fields = "{ 'id' : 1, 'name' : 1, 'username' : 1, 'email' : 1, 'password' : 1 }")
    List<UserResource> findAllUsers();
}
