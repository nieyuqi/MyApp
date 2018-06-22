package com.example.nyq.myapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nyq.myapp.R;
import com.example.nyq.myapp.model.pojo.ProductBean;
import com.example.nyq.myapp.model.service.serviceImp.ProdImp;

import java.util.List;

/**
 * Created by nyq on 2018/5/3.
 */

public class SelectFragment extends Fragment implements View.OnClickListener {

    private EditText prodNameEdit;
    private EditText prodPriceEdit;
    private EditText prodCodingEdit;
    private Button updateButton;
    private View deleteButton;
    private Button selectButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_fragment, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        prodNameEdit = (EditText) view.findViewById(R.id.prod_name_edit);
        prodPriceEdit = (EditText) view.findViewById(R.id.prod_price);
        prodCodingEdit = (EditText) view.findViewById(R.id.prod_coding);
        updateButton = (Button) view.findViewById(R.id.update_button);
        deleteButton = view.findViewById(R.id.delete_button);
        selectButton = (Button) view.findViewById(R.id.select_button);

        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        selectButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_button:


                break;
            case R.id.delete_button:

                break;
            case R.id.select_button:

                ProductBean productBean = new ProductBean();
                productBean.setCode("6927562900354");

                List<ProductBean> prod = ProdImp.getInstence().findProd(productBean);


                break;
        }
    }
}
