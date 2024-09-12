package com.project.taskmanagement.repository;
import com.project.taskmanagement.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepository extends MongoRepository<Program, String> {

}
