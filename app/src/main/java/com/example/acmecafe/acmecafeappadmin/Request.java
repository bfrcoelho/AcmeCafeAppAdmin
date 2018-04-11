package com.example.acmecafe.acmecafeappadmin;

/**
 * Created by Bruno Coelho on 04/04/2018.
 */

public class Request {
    public String id;


    public Request(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

