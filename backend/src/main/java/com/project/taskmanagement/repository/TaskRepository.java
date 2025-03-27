package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    @Query("{'programId': ?0}")
    List<Task> findByProgramId(String programId);
    
    @Query("{'createdById': ?0}")
    List<Task> findByCreatedById(String userId);
    
    @Query("{'programId': ?0, 'status': ?1}")
    List<Task> findByProgramIdAndStatus(String programId, String status);
}
