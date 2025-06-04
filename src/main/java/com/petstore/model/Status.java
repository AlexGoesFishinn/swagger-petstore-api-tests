package com.petstore.model;

import java.util.Random;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    public final String string;
    private Status(String status){
        this.string = status;
    }


}
