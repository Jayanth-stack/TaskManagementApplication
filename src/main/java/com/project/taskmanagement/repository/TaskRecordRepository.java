package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.TaskRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRecordRepository extends MongoRepository<TaskRecord, String> {

}
