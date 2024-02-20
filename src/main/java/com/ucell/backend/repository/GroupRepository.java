package com.ucell.backend.repository;

import com.ucell.backend.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends Neo4jRepository<Group,Long> {


    Page<Group> findByRtplIdAndDirection(String id, String in,Pageable pageable);

    @Query(
            value = "match (n:Group{rtplId:$id,direction:$in}) return n skip $skip limit $limit",
            countQuery = "match (n:Group) return count(n)")
    Page<Group> findByRtplIdAndDirectionOnlyNode(String id, String in,Pageable pageable);

    Page<Group> findByRtplId(String rtplId,Pageable pageable);

    @Query(
            value = "match (n:Group{rtplId:$id}) return n skip $skip limit $limit",
            countQuery = "match (n:Group) return count(n)")
    Page<Group> findByRtplIdOnlyNode(String id,Pageable pageable);

    @Query(
            value = "match (n:Group) return n skip $skip limit $limit",
            countQuery = "match (n:Group) return count(n)")
    Page<Group> findAllOnlyNode(Pageable pageable);

    Page<Group> findAllByDirection(String direction, Pageable pageable);

    @Query(
            value = "match (n:Group{direction:$direction}) return n skip $skip limit $limit",
            countQuery = "match (n:Group{direction:$direction}) return count(n)")
    Page<Group> findAllByDirectionOnlyNode(String direction, Pageable pageable);
}
