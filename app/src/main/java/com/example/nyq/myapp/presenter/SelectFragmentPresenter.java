package com.example.nyq.myapp.presenter;

import com.example.nyq.myapp.model.pojo.ProductBean;
import com.example.nyq.myapp.model.service.IProdService;
import com.example.nyq.myapp.model.service.serviceImp.ProdImp;
import com.example.nyq.myapp.view.ISeletFragmentView;

import java.util.List;

/**
 * Created by nyq on 2018/6/22.
 */

public class SelectFragmentPresenter {
    private ISeletFragmentView seletFragmentView;
    private IProdService prodService;

    public SelectFragmentPresenter(ISeletFragmentView seletFragmentView) {
        this.seletFragmentView = seletFragmentView;
        prodService = new ProdImp();
    }

    public List<ProductBean> selectProd(ProductBean productBean) {
        List<ProductBean> prod = prodService.findProd(productBean);

        initProdInfo(prod);
        return prod;
    }

    public void update(ProductBean productBean) {

    }

    public void initCode(String code) {

        if (seletFragmentView != null) {
            seletFragmentView.initCode(code);
        }
    }

    private void initProdInfo(List<ProductBean> productBean) {
        seletFragmentView.initProdInfo(productBean);
    }

}
