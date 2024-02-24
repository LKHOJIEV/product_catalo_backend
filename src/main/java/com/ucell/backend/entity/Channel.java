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
public class Channel {

    @Id
    @GeneratedValue
    private Long id;
    private String channelId;
    private String name;
    private String type;

    @Relationship(type = "available_in",direction = Relationship.Direction.OUTGOING)
    private Set<BundledProductOffering> offers;

    public void available_in(BundledProductOffering offer) {
        if (offers == null) {
            offers = new HashSet<>();
        }
        offers.add(offer);
    }

}
