package com.petstore.model;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    public final String string;
    Status(String status){
        this.string = status;
    }


}
