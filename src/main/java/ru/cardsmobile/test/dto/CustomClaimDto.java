package ru.cardsmobile.test.dto;

import lombok.Data;

@Data
public class CustomClaimDto extends ClaimDto {
    private String customField;
}
