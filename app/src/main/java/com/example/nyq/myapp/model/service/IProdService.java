package com.example.nyq.myapp.model.service;

import com.example.nyq.myapp.model.pojo.ProductBean;

import java.util.List;

/**
 * Created by nyq on 2018/6/22.
 */

public interface IProdService {

    List<ProductBean> findProd(ProductBean productBean);
    int deleteProd(ProductBean productBean);
    boolean addProd(ProductBean productBean);
    int update(ProductBean oldProd, ProductBean newProd);



}
