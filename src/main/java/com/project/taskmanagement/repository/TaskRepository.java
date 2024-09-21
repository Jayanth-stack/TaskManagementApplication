package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, Long> {
    List<Task> findByProgram(long program);
}
