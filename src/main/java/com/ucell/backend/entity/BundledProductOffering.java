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
public class BundledProductOffering {

    @Id
    @GeneratedValue
    private String id;

    private String rtplId;
    private String isBundle;
    private String code;
    private String name;
    private String activeStart;
    private String externalId;
    private String ctypId;
    private String ccatId;
    private String activeEnd;
    private String isActive;
    private String rptpId;
    private String type;

    @Relationship(type = "has",direction = Relationship.Direction.OUTGOING)
    public Set<Characteristics> characteristics;

    public void belongs(Characteristics characteristic) {
        if (characteristics == null) {
            characteristics = new HashSet<>();
        }
        characteristics.add(characteristic);
    }

}
