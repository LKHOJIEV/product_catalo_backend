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

@Node
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Characteristics {

    @Id
    @GeneratedValue
    private Long id;
    private String definition;
    private String definitionEn;
    private String definitionRu;
    private String definitionUz;
    private String name;
    private String rtplId;
    private String type;

    @Relationship(type = "has_characteristics",direction = Relationship.Direction.OUTGOING)
    private Set<Characteristics_details> details;

    public void has_characteristics(Characteristics_details characteristics_details) {
        if (details == null) {
            details = new HashSet<>();
        }
        details.add(characteristics_details);
    }

}
