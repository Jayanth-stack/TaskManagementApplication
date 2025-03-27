package com.project.taskmanagement.resource;

import com.project.taskmanagement.entity.TaskRecord;

import java.util.List;

public class TaskRecordListResource {

    private List<TaskRecord> taskRecordList;

    public List<TaskRecord> getTaskRecordList() {
        return taskRecordList;
    }

    public void setTaskRecordList(List<TaskRecord> taskRecordList) {
        this.taskRecordList = taskRecordList;
    }
}
