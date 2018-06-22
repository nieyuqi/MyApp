package com.example.nyq.myapp.model.service.serviceImp;

import android.content.ContentValues;

import com.example.nyq.myapp.model.pojo.ProductBean;
import com.example.nyq.myapp.model.service.IProdService;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by nyq on 2018/6/22.
 */

public class ProdImp implements IProdService {

    private static ProdImp prodImp;

    public static ProdImp getInstence() {
        if (prodImp == null) {
            prodImp = new ProdImp();
        }

        return prodImp;
    }

    @Override
    public List<ProductBean> findProd(ProductBean productBean) {

        List<ProductBean> productBeans = null;

        if (productBean != null) {
            productBeans = DataSupport.where("code=?", productBean.getCode()).find(ProductBean.class);
        } else {
            productBeans = DataSupport.findAll(ProductBean.class);
        }
        return productBeans;
    }

    @Override
    public int deleteProd(ProductBean productBean) {

        int lines = DataSupport.deleteAll("code=?", productBean.getCode());

        return lines;
    }

    @Override
    public boolean addProd(ProductBean productBean) {
        if (productBean != null) {
            return productBean.save();
        }

        return false;
    }

    @Override
    public int update(ProductBean oldProd, ProductBean newProd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", newProd.getName());
        contentValues.put("price", newProd.getPrice());
        contentValues.put("time", System.currentTimeMillis());
        contentValues.put("code", newProd.getCode());

        int line = DataSupport.updateAll(ProductBean.class, contentValues, "code=?", oldProd.getCode());

        return line;
    }
}
