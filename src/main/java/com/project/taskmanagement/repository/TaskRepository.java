package com.project.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.core.messaging.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {

    Task findById();

    void deleteById(int id);
}
