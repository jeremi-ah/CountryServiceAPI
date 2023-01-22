package com.country.springbootcountryservice.controllers;

public class AddResponse {
   private String Message;
   private int id;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
