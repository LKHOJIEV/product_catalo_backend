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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Characteristics_details {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String name;
    private String definition;
    private String modifier_pack_name;

    private String definitionRu;
    private String definitionEn;
    private String definitionUz;

    private String techPackId;
    private String rtplId;
    private String packId;
    private String cosId;
    private String restart_id;
    private String modifier_pack_id;

    private String unitPrice;
    private String price;
    private String volume;
    private String modifier_pack_price;
    private String modified_tariff_price;
    private String measureUnit;
    private String priority;
    private String code;

    private String price_period;
    private String modifier_pack_duration_days;
    private String modifier_pack_duration_month;
    private String modifier_pack_charge_type;

    private String discountGroup;
    private String aliasDefinition;
    private String dcplId;




    /**
     *  "properties": {
     *     "volume": "45000",
     *     "code": "rtpl",
     *     "rtplId": "3",
     *     "techPackId": "33",
     *     "name": "call_credit",
     *     "measureUnit": "Минута",
     *     "definition": "Doimiy VOICE",
     *     "aliasDefinition": "мин.",
     *     "dcplId": "20021",
     *     "type": "call_credit",
     *     "priority": "90000",
     *     "discountGroup": "4"
     *   },
     *
     * {
     *     "modifier_pack_name": "Airtime Onnet Bundle 300 Postpaid",
     *     "modifier_pack_charge_type": "Периодическое начисление",
     *     "modifier_pack_duration_month": "",
     *     "modifier_pack_id": "220",
     *     "modified_tariff_price": "0",
     *     "name": "tariff_modifiers",
     *     "rtpl_id": "16",
     *     "definition": "tariff_modifiers",
     *     "type": "tariff_modifiers",
     *     "modifier_pack_duration_days": "",
     *     "modifier_pack_price": "12587.9"
     *   },
     *
     *
     *
     */

}
