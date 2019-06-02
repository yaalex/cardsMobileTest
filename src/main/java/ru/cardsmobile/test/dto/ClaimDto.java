package ru.cardsmobile.test.dto;

import ru.cardsmobile.test.model.ClaimStatus;
import ru.cardsmobile.test.model.MegaClaim;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = CustomClaimDto.class, name = "custom"),
        @JsonSubTypes.Type(value = MegaClaim.class, name = "mega") })
public class ClaimDto {
    private String id;
    private ClaimStatus claimStatus;
    private String type;
}
