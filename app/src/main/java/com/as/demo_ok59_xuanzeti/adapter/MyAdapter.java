package com.as.demo_ok59_xuanzeti.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * -----------------------------
 * Created by zqf on 2019/12/17.
 * ---------------------------
 */
public class MyAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;


    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void setmFragments(ArrayList<Fragment> mFragments) {
        this.mFragments = mFragments;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

}
