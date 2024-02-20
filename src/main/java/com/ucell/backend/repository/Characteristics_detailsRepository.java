package com.ucell.backend.repository;

import com.ucell.backend.entity.Characteristics_details;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Characteristics_detailsRepository extends Neo4jRepository<Characteristics_details,Long> {


}
