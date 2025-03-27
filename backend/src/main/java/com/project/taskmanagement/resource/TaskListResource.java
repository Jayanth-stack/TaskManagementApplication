package com.project.taskmanagement.resource;

import com.project.taskmanagement.entity.Task;

import java.util.List;

public class TaskListResource {

    private List<Task> taskList;

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
