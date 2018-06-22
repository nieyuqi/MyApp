package com.example.nyq.myapp.model.service.serviceImp;

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
    public boolean deleteProd(ProductBean productBean) {
        return false;
    }

    @Override
    public boolean addProd(ProductBean productBean) {
        if (productBean != null) {
           return productBean.save();
        }

        return false;
    }

    @Override
    public void update(ProductBean oldProd, ProductBean newProd) {

    }
}
