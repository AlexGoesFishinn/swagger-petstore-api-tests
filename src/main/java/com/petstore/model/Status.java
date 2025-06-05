package com.petstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("available")
    AVAILABLE("available"),
    @JsonProperty("pending")
    PENDING("pending"),
    @JsonProperty("sold")
    SOLD("sold");

    public final String string;
    Status(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
