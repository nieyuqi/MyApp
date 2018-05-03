package com.example.nyq.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nyq.myapp.R;

/**
 * Created by nyq on 2018/5/3.
 */

public class AddFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return  inflater.inflate(R.layout.add_fragment, container, false);
    }
}
