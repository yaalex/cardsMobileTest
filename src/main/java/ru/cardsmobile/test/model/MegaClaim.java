package ru.cardsmobile.test.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class MegaClaim extends Claim {
    private String megaField;
}
