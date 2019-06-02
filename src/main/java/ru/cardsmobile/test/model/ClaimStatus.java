package ru.cardsmobile.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClaimStatus {
    @JsonProperty("NEW")
    NEW,
    @JsonProperty("DONE")
    DONE;
}
