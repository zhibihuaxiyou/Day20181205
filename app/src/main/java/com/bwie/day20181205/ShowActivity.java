package com.bwie.day20181205;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.day20181205.fragment.MyCardFragment;
import com.bwie.day20181205.fragment.MyDataFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ShowActivity extends AppCompatActivity {

    private BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottonTabBar);
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("我的数据",R.drawable.data, MyDataFragment.class)
                .addTabItem("我的名片",R.drawable.card, MyCardFragment.class);
    }
}
