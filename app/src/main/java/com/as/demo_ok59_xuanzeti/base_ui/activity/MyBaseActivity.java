package com.as.demo_ok59_xuanzeti.base_ui.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.as.demo_ok59_xuanzeti.R;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * -----------------------------
 * Created by zqf on 2018/7/4.
 * ---------------------------
 */

@SuppressLint("Registered")
public class MyBaseActivity extends SupportActivity {

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



}
