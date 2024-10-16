package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.TaskRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRecordRepository extends MongoRepository<TaskRecord, Long> {
    @Query("{ 'user' : ?0 }")
    List<TaskRecord> getTaskRecordByUser(long user);

    List<TaskRecord> findByProgramAndUser(long program, long user);

    TaskRecord findByProgramAndUserAndTask(long program, long user, long task);
}
