package com.ucell.backend.repository;

import com.ucell.backend.entity.Tariff;
import org.springframework.data.domain.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface TariffRepository extends Neo4jRepository<Tariff,Long> {


    Page<Tariff> findAll(Pageable pageable);

    @Query(
            value = "match (n:Tariff{rtplId:$id,state:$state}) return n skip $skip limit $limit",
            countQuery = "match (n:Tariff{rtplId:$id,state:$state}) return count(n)")
    Page<Tariff> findByRtplIdAndStateOnlyNode(String id, String state, Pageable pageable);

    Page<Tariff> findByRtplIdAndState(String rtplId, String state, Pageable pageable);

    @Query(
            value = "match (n:Tariff{state:$state}) return n skip $skip limit $limit",
            countQuery = "match (n:Tariff{state:$state}) return count(n)")
    Page<Tariff> findAllByStateOnlyNode(String state, Pageable pageable);

    Page<Tariff> findAllByState(String state, Pageable pageable);
}
