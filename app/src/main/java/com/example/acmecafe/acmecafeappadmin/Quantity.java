package com.example.acmecafe.acmecafeappadmin;


/**
 * Created by Bruno Coelho on 05/04/2018.
 */

public class Quantity {

    public Long quantity;

    public Quantity(Long quantity) {
        this.quantity = quantity;
    }

    public Quantity(){
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
