package com.project.taskmanagement.service;

import com.project.taskmanagement.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.messaging.Task;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceImpl implements Service{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(int id) {
        return taskRepository.findById();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);

    }

}
