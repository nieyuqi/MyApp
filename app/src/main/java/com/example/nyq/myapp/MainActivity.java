package com.example.nyq.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.special.ResideMenu.ResideMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResideMenu resideMenu = new ResideMenu(this);
    }
}
