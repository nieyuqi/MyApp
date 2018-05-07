package com.example.nyq.myapp.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dommy.qrcode.util.Constant;
import com.example.nyq.myapp.R;
import com.google.zxing.activity.CaptureActivity;

import static android.app.Activity.RESULT_OK;

/**
 * Created by nyq on 2018/5/3.
 */

public class AddFragment extends Fragment implements View.OnClickListener {

    Button btnQrCode; // 扫码
    TextView tvResult; // 结果

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment2, container, false);

        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_CAMERA);

        initView(view);
        return view;
    }

    private void initView(View view) {
        btnQrCode = (Button) view.findViewById(com.dommy.qrcode.R.id.btn_qrcode);
        btnQrCode.setOnClickListener(this);

        tvResult = (TextView) view.findViewById(com.dommy.qrcode.R.id.txt_result);
    }

    // 开始扫码
    private void startQrCode() {

        // 二维码扫码
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == com.dommy.qrcode.R.id.btn_qrcode) {
//            startQrCode();
//            SQLiteDatabase database = Connector.getDatabase();


        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
            //将扫描出的信息显示出来
            tvResult.setText(scanResult);
        }
    }
}
