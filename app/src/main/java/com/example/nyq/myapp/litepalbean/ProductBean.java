package com.example.nyq.myapp.litepalbean;

import org.litepal.crud.DataSupport;

import java.sql.Date;

/**
 * Created by nyq on 2018/5/7.
 */

public class ProductBean extends DataSupport{
   private String brand;
   private String mode;
   private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
