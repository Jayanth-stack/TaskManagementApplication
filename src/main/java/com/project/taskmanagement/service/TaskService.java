package com.project.taskmanagement.service;

import com.project.taskmanagement.dto.WorkDTO;
import com.project.taskmanagement.entity.TaskRecord;
import com.project.taskmanagement.repository.TaskRecordRepository;
import com.project.taskmanagement.repository.TaskRepository;
import com.project.taskmanagement.resource.TaskListResource;
import com.project.taskmanagement.resource.TaskRecordListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.taskmanagement.entity.Task;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    public void createTask(Task task, long[] trainees){
        Task savedTask = taskRepository.save(task);
        long program = savedTask.getProgram();
        this.initTaskRecords(trainees, savedTask.getId(), program);

    }
    public void initTaskRecords(long[] trainees, long taskId, long program){
        for(long id : trainees){
            TaskRecord taskRecord = new TaskRecord();
            taskRecord.setId(id);
            taskRecord.setTask(taskId);
            taskRecord.setProgram(program);
            taskRecord.setWork("No work Done Yet!!");
            taskRecordRepository.save(taskRecord);
        }
    }
    public List<Task> getTasksFromTaskRecord(List<TaskRecord> taskRecords){
        List<Task> tasks = new ArrayList<>();
        for(TaskRecord taskRecord : taskRecords){
            tasks.add(taskRepository.findById(taskRecord.getTask()).get());
        }
        return tasks;
    }
    public TaskListResource getAllTask(){
        List<Task> taskList = (List<Task>) taskRepository.findAll();
        TaskListResource taskListResource = new TaskListResource();
        taskListResource.setTaskList(taskList);
        return taskListResource;
    }
    public TaskRecordListResource getAllTaskRecord(){
        TaskRecordListResource taskRecordListResource = new TaskRecordListResource();
        taskRecordListResource.setTaskRecordList((List<TaskRecord>) taskRecordRepository.findAll());
        return taskRecordListResource;
    }
    public TaskListResource getAllTaskByProgram(long pid){
        List<Task> taskList = (List<Task>) taskRepository.findByProgram(pid);
        TaskListResource taskListResource = new TaskListResource();
        taskListResource.setTaskList(taskList);
        return taskListResource;
    }
    public TaskRecordListResource getAllTaskRecordOfUserAndProgram(long uid, long pid) {
        TaskRecordListResource trlr = new TaskRecordListResource();
        List<TaskRecord> trl = taskRecordRepository.findByProgramAndUser(pid, uid);
        trlr.setTaskRecordList(trl);
        return trlr;
    }

    public TaskListResource getAllTaskOfUserAndProgram(long uid, long pid) {
        TaskListResource tlr = new TaskListResource();
        List<Task> tl = this.getTasksFromTaskRecord(taskRecordRepository.findByProgramAndUser(pid, uid));
        tlr.setTaskList(tl);
        return tlr;
    }

    public WorkDTO getWork(long uid, long pid, long tid) {
        TaskRecord tr = taskRecordRepository.findByProgramAndUserAndTask(pid, uid, tid);
        WorkDTO dto = new WorkDTO();
        dto.setWork(tr.getWork() != null ? tr.getWork() : "");

        return dto;
    }

    public void addWork(long uid, long pid, long tid, String work) {
        TaskRecord tr = taskRecordRepository.findByProgramAndUserAndTask(pid, uid, tid);
        tr.setWork(work);
        taskRecordRepository.save(tr);
    }


}
