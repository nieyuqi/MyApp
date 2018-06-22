package com.example.nyq.myapp.presenter;

import com.example.nyq.myapp.model.pojo.ProductBean;
import com.example.nyq.myapp.model.service.IProdService;
import com.example.nyq.myapp.model.service.serviceImp.ProdImp;
import com.example.nyq.myapp.view.IAddFragmentView;

/**
 * Created by nyq on 2018/6/22.
 */

public class AddFragmentPresenter {
    private IAddFragmentView addFragmentView;
    private IProdService prodImp;

    public AddFragmentPresenter(IAddFragmentView addFragmentView) {
        this.addFragmentView = addFragmentView;
        prodImp = ProdImp.getInstence();
    }


    public void initCode(String scanResult) {
        addFragmentView.initCode(scanResult);
    }

    public void saveProd(ProductBean productBean) {
        boolean b = prodImp.addProd(productBean);

        addFragmentView.showToast(b);

    }
}
