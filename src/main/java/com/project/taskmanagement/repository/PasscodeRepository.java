package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Passcode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PasscodeRepository extends MongoRepository<Passcode, Long> {

    @Query(value = "{ 'code' : ?0 }", fields = "{ 'pid' : 1, '_id' : 0 }")
    Long getPidByCode(String code);
}
