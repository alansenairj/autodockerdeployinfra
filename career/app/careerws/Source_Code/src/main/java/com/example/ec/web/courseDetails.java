package com.example.ec.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class courseDetails {


    private String title;

    private String price;


    public courseDetails(String title, String price) {
        this.title = title;
        this.price = price;
    }

    protected courseDetails() {}



    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }



    public void getTitle(String title) {
        this.title = title;
    }

    public void getPrice(String price) {
        this.price = price;
    }


}
