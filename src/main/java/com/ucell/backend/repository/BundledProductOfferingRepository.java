package com.ucell.backend.repository;

import com.ucell.backend.entity.BundledProductOffering;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BundledProductOfferingRepository extends Neo4jRepository<BundledProductOffering,String> {

    Page<BundledProductOffering> findByRtplId(String rtplId, Pageable pageable);

    @Query(value = "match (n:BundledProductOffering{rtplId:$rtplId}) return n skip $skip limit $limit",
            countQuery = "match (n:BundledProductOffering{rtplId:$rtplId}) return count(n)")
    Page<BundledProductOffering> findByRtplIdOnlyNode(String rtplId, Pageable pageable);

    @Query(
            value = "match (n:BundledProductOffering) return n skip $skip limit $limit",
    countQuery = "match (n:BundledProductOffering) return count(n)")
    Page<BundledProductOffering> findAllOnlyNode(Pageable pageable);

}
