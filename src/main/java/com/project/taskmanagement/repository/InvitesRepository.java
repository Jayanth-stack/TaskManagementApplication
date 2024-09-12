package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.Invites;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvitesRepository extends MongoRepository<Invites, String> {

}
