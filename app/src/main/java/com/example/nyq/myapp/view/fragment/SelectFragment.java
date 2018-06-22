package com.example.nyq.myapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dommy.qrcode.util.Constant;
import com.example.nyq.myapp.R;
import com.example.nyq.myapp.model.pojo.ProductBean;
import com.example.nyq.myapp.presenter.IQRPresenter;
import com.example.nyq.myapp.presenter.SelectFragmentPresenter;
import com.example.nyq.myapp.view.ISeletFragmentView;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by nyq on 2018/5/3.
 */

public class SelectFragment extends Fragment implements View.OnClickListener, ISeletFragmentView {

    private EditText prodNameEdit;
    private EditText prodPriceEdit;
    private EditText prodCodingEdit;
    private Button updateButton;
    private View deleteButton;
    private Button selectButton;
    private Button scanCodeButton;
    private SelectFragmentPresenter selectFragmentPresenter;

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
        scanCodeButton = (Button) view.findViewById(R.id.scan_code_button);

        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        selectButton.setOnClickListener(this);
        scanCodeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_button:


                break;
            case R.id.delete_button:

                break;
            case R.id.select_button:

                String code = prodCodingEdit.getText().toString();

                ProductBean productBean = new ProductBean();
                productBean.setCode(code);

                getSelectFragmentPresenter().selectProd(productBean);


                break;
            case R.id.scan_code_button:
                IQRPresenter iqrPresenter = new IQRPresenter(this);
                iqrPresenter.scanCode();

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);

            getSelectFragmentPresenter().initCode(scanResult);

        }
    }

    private SelectFragmentPresenter getSelectFragmentPresenter() {

        if (selectFragmentPresenter == null) {

            selectFragmentPresenter = new SelectFragmentPresenter(this);
        }

        return selectFragmentPresenter;
    }

    @Override
    public void showToast(boolean msg) {

    }

    @Override
    public void initCode(String codeing) {
        prodCodingEdit.setText(codeing);
    }

    @Override
    public void initProdInfo(List<ProductBean> productBean) {
        if (productBean != null && productBean.size() > 0) {
            prodCodingEdit.setText(productBean.get(0).getCode());
            prodNameEdit.setText(productBean.get(0).getName());
            prodPriceEdit.setText(productBean.get(0).getPrice());
        } else {
            Toast.makeText(getContext(), R.string.no_data, Toast.LENGTH_SHORT).show();
        }
    }
}
