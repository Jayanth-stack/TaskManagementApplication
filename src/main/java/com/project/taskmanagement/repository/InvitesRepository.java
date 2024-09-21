package com.project.taskmanagement.repository;
import java.util.List;
import com.project.taskmanagement.entity.Invites;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitesRepository extends MongoRepository<Invites, Long> {

    Boolean existsByUid(long uid);

    @Query("{ 'uid' : ?0 }")
    Invites findByUid(long uid);

    @Query(value="{ 'uid' : ?0 }", fields="{ 'pid' : 1, '_id' : 0 }")
    Long getPidByUid(long uid);

    @Query(value="{ 'uid' : ?0 }", fields="{ 'pid' : 1, '_id' : 0 }")
    List<Long> findPidsByUid(long uid);

    List<Invites> findByPid(long pid);

}
