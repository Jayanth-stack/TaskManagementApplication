package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends MongoRepository<Program, String> {
    @Query("{'adminId': ?0}")
    List<Program> findAllByAdminId(String adminId);
    
    Optional<Program> findByCode(String code);
}
