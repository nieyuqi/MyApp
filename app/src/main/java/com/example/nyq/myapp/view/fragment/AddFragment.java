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
import android.widget.ImageView;
import android.widget.Toast;

import com.dommy.qrcode.util.Constant;
import com.example.nyq.myapp.R;
import com.example.nyq.myapp.model.pojo.ProductBean;
import com.example.nyq.myapp.presenter.AddFragmentPresenter;
import com.example.nyq.myapp.presenter.IQRPresenter;
import com.example.nyq.myapp.view.IAddFragmentView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by nyq on 2018/5/3.
 */

public class AddFragment extends Fragment implements View.OnClickListener, IAddFragmentView {

    private ImageView prodIv;
    private EditText prodNameEdit;
    private EditText prodPriceEdit;
    private Button submitButton;
    private EditText prodCodingEdit;
    private Button scanCodeButton;
    private AddFragmentPresenter addFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        prodIv = view.findViewById(R.id.prod_iv);
        prodNameEdit = view.findViewById(R.id.prod_name_edit);
        prodPriceEdit = view.findViewById(R.id.prod_price);
        submitButton = (Button) view.findViewById(R.id.submit_but);
        prodCodingEdit = (EditText) view.findViewById(R.id.prod_coding);
        scanCodeButton = view.findViewById(R.id.scan_code);

        submitButton.setOnClickListener(this);
        scanCodeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.submit_but:
                String name = prodNameEdit.getText().toString();
                String price = prodPriceEdit.getText().toString();
                String prodCoding = prodCodingEdit.getText().toString();

                ProductBean productBean = new ProductBean(name, price, System.currentTimeMillis(), prodCoding);

                getAddFragmentPresenter().saveProd(productBean);
                break;
            case R.id.scan_code:

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

            getAddFragmentPresenter().initCode(scanResult);

        }
    }

    private AddFragmentPresenter getAddFragmentPresenter() {

        if (addFragmentPresenter == null) {

            addFragmentPresenter = new AddFragmentPresenter(this);
        }

        return addFragmentPresenter;
    }

    @Override
    public void showToast(boolean msg) {
        if (msg) {
            Toast.makeText(getContext(), getResources().getString(R.string.save_success), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), getResources().getString(R.string.save_fail), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void initCode(String codeing) {
        prodCodingEdit.setText(codeing);
    }


}
