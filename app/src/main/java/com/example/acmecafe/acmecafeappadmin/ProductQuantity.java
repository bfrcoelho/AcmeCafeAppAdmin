package com.example.acmecafe.acmecafeappadmin;


/**
 * Created by Bruno Coelho on 05/04/2018.
 */

public class ProductQuantity {
//    Product product;
//    Quantity quantity;
//
//    public ProductQuantity(Product product, Quantity quantity) {
//        this.product = product;
//        this.quantity = quantity;
//    }
//
//    public String toString() {
//
//        if (this.product.name.length() > 20){
//            return this.product.name.substring(0, 20) + "  " + this.quantity;
//        } else{
//            return this.product.name + "  " + this.quantity;
//        }
//
//
//    }
//
//    public String getName(){
//        return this.product.name;
//    }
//
//    public int getId(){
//        return this.product.id_product;
//    }
//
//    public Quantity getQuantity() {
//        return quantity;
//    }

    Product product;
    Long quantity;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public ProductQuantity(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getName(){
        return this.product.getName();
    }

    public int getId(){
        return this.product.id_product;
    }


}
