package com.example.nyq.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ResideMenu resideMenu;
    private ResideMenuItem addItem;
    private ResideMenuItem selectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setUpMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(MainActivity.this, "is open", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(MainActivity.this, "is close", Toast.LENGTH_SHORT).show();
        }
    };


    private void setUpMenu() {
        resideMenu = new ResideMenu(getApplicationContext());
        resideMenu.attachToActivity(this);
        resideMenu.setBackground(R.mipmap.menu_background);
        resideMenu.setScaleValue(0.6f);
        resideMenu.setUse3D(true);
        resideMenu.setMenuListener(menuListener);

        addItem = new ResideMenuItem(getApplicationContext(), R.mipmap.icon_home, "新增");
        selectItem = new ResideMenuItem(getApplicationContext(), R.mipmap.icon_profile, "查找");

        resideMenu.addMenuItem(addItem, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(selectItem, ResideMenu.DIRECTION_LEFT);

        addItem.setOnClickListener(this);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
        if (addItem == view) {

        }

    }
}
