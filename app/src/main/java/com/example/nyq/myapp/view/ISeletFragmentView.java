package com.example.nyq.myapp.view;

import com.example.nyq.myapp.model.pojo.ProductBean;

/**
 * Created by nyq on 2018/6/22.
 */

public interface ISeletFragmentView {

    void showToast(boolean msg);

    void initCode(String codeing);
    void initProdInfo(ProductBean productBean);
}
