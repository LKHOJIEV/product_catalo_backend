package com.ucell.backend.repository;

import com.ucell.backend.entity.Users;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends Neo4jRepository<Users,String> {

    //@Query(value = "match (u:Users{name:'?1',password:'?2'}) return u")
    Users findByNameAndPassword(String name, String password);

    Optional<Users> findByName(String name);

}
