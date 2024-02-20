package com.ucell.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tariff {
@Id
    @GeneratedValue
    private Long id;
    private String group_id;
    private String rtplId;
    private String rtplName;
    private String state;
    private String price_modifier;
    private String from_rtpl_id;


/**
 * group_id
 * rtplId	349
 * rtplName	7 Giga 12 month
 * state	init
 */


}
