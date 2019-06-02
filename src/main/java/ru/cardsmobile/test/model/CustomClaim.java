package ru.cardsmobile.test.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CustomClaim extends Claim {
    private String customField;
}
