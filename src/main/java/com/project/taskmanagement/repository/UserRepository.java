package com.project.taskmanagement.repository;
import com.project.taskmanagement.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
