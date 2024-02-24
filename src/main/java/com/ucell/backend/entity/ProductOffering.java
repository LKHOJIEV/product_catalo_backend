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
public class ProductOffering {

    @Id
    @GeneratedValue
    private Long id;
    private String isBundle;
    private String code;
    private String durDays;
    private String ptypId;
    private String productId;
    private String name;
    private String description;
    private String activeStart;
    private String isCart;
    private String activeEnd;
    private String durMonths;
    private String type;

    @Relationship(type = "product_offering_relationship",direction = Relationship.Direction.OUTGOING)
    private Set<BundledProductOffering> product_offering_relationship;

    public void productOfferingRelationship(BundledProductOffering offering) {
        if (product_offering_relationship == null) {
            product_offering_relationship = new HashSet<>();
        }
        product_offering_relationship.add(offering);
    }

}
