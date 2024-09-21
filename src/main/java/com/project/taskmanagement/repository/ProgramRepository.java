package com.project.taskmanagement.repository;
import com.project.taskmanagement.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends MongoRepository<Program, Long> {

    List<Program> findByAdmin(long admin);

}
