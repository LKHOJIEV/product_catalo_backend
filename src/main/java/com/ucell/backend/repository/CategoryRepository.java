package com.ucell.backend.repository;

import com.ucell.backend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends Neo4jRepository<Category, String> {



    Page<Category> findAll(Pageable pageable);

    @Query(
            value = "match (n:Category) return n skip $skip limit $limit",
            countQuery = "match (n:Category) return count(n)")
    Page<Category> findAllOnlyNode(Pageable pageable);

    Page<Category> findByCategoryId(String id,Pageable pageable);

    @Query(
            value = "match (n:Category{categoryId:$id}) return n skip $skip limit $limit",
            countQuery = "match (n:Category{categoryId:$id}) return count(n)")
    Page<Category> findByCategoryIdOnlyNode(String id,Pageable pageable);

}

