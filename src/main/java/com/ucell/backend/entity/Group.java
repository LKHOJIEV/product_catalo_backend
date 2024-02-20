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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

@Id
    @GeneratedValue
    private Long id;
    private String direction;
    private String group_id;
    private String rtplId;
    private String type;

    @Relationship(value = "has_rule_policy")
    private Group out;

    @Relationship(value = "belongs_to",direction = Relationship.Direction.INCOMING)
    private Set<Tariff> tariffs;

    public void belongs_to(Tariff tariff) {
        if (tariffs == null) {
            tariffs = new HashSet<>();
        }
        tariffs.add(tariff);
    }


/**
     * direction	out
     * group_id
     * rtplId	184
     * type	any
     */

}
