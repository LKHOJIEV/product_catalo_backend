package com.ucell.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Node
public class Category {


    @Id
    @GeneratedValue
    private String id;
    private String categoryId;
    private String name;
    private String type;

    @Relationship(type = "belongs",direction = Relationship.Direction.INCOMING)
    public Set<BundledProductOffering> belongs;

    public void belongs(BundledProductOffering bundledProductOffering) {
        if (belongs == null) {
            belongs = new HashSet<>();
        }
        belongs.add(bundledProductOffering);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
