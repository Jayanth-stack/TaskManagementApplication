package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Passcode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasscodeRepository extends MongoRepository<Passcode, String> {

}
