package com.example.nyq.myapp.model.pojo;

import org.litepal.crud.DataSupport;

/**
 * Created by nyq on 2018/5/7.
 */

public class ProductBean extends DataSupport{
   private String name;
   private String price;
   private long time;
   private String code;
   private int age;

    public ProductBean(String name, String price, long time, String code, int age) {
        this.name = name;
        this.price = price;
        this.time = time;
        this.code = code;
        this.age = age;
    }

    public ProductBean() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public long getTime() {
        return time;
    }
}
