package com.project.taskmanagement.service;

import org.springframework.data.mongodb.core.messaging.Task;

import java.util.List;

public interface Service {
    public List<Task>getTasks();

    public Task getTask(int id);
    public Task createTask(Task task);
    public Task updateTask(Task task);
    public void deleteTask(int id);



}
