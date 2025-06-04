package com.petstore.model;

import java.util.Random;

public enum Status {
    available("available"),
    pending("pending"),
    sold("sold");

    public final String status;
    private Status(String status){
        this.status = status;
    }


}
