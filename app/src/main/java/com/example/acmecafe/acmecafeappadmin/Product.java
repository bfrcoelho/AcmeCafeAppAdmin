package com.example.acmecafe.acmecafeappadmin;

/**
 *
 * Created by Bruno Coelho on 15/03/2018.
 */

public class Product {
    int id_product;
    String name;
    String price;

    public Product() {

    }

    public Product(int id_product,String nome,String price) {
        this.id_product=id_product;
        this.name = nome;
        this.price=price;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
