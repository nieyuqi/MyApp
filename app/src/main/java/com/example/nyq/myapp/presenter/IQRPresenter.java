package com.example.nyq.myapp.presenter;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.dommy.qrcode.util.Constant;
import com.google.zxing.activity.CaptureActivity;

/**
 * Created by nyq on 2018/6/22.
 */

public class IQRPresenter {

    private Fragment fragment;

    public IQRPresenter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void scanCode() {
        Intent intent = new Intent(fragment.getContext(), CaptureActivity.class);
        fragment.startActivityForResult(intent, Constant.REQ_QR_CODE);
    }
}
