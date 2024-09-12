package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

}
