package com.as.demo_ok59_xuanzeti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.as.demo_ok59_xuanzeti.adapter.MyAdapter;
import com.as.demo_ok59_xuanzeti.base_ui.activity.BaseActivity;
import com.as.demo_ok59_xuanzeti.bean.DataBean;
import com.as.demo_ok59_xuanzeti.bean.SeriBean;
import com.as.demo_ok59_xuanzeti.bean.UserDataBean;
import com.as.demo_ok59_xuanzeti.databinding.ActivityMainBinding;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements BlankFragment.Ilistener {

    int i = 0;
    private List<DataBean> list;

    private List<UserDataBean> userDataBeans = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {
    }

    @Override
    protected void initView() {

        final ArrayList<String> content0 = new ArrayList<String>() {
            {
                for (int i = 0; i < 4; i++) {
                    add("选项" + i);
                }
            }
        };
        list = new ArrayList<DataBean>() {
            {
                DataBean question = new DataBean("第一题", content0, 0);
                DataBean question1 = new DataBean("第二题", content0, 1);
                DataBean question2 = new DataBean("第三题", content0, 3);
                DataBean question3 = new DataBean("第四题", content0, 2);
                DataBean question4 = new DataBean("第五题", content0, 3);
                DataBean question5 = new DataBean("第六题", content0, 2);
                DataBean question6 = new DataBean("第七题", content0, 1);

                add(question);
                add(question1);
                add(question2);
                add(question3);
                add(question4);
                add(question5);
                add(question6);

            }
        };


        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{

            for (int i = 0; i < list.size(); i++) {
                BlankFragment blankFragment = BlankFragment.getInstance(list.get(i));
                blankFragment.setIlistener(MainActivity.this);
                add(blankFragment);
            }
        }};

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        myAdapter.setmFragments(fragmentList);

        mViewBinding.vp.setAdapter(myAdapter);

        mViewBinding.but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewBinding.right.setmIsRight(true);
                mViewBinding.right.start();
            }
        });

        mViewBinding.but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewBinding.left.setmIsRight(false);
                mViewBinding.left.start();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    private int rightCount = 0;

    @Override
    public void listener(boolean isRifht, int useTime) {

        if (isRifht) {
            rightCount++;
        }

        if (i == list.size() - 1) {
            userDataBeans.add(new UserDataBean(i, useTime, isRifht));
            ToastUtils.showShort("一共答对" + rightCount + "道题");
            Intent intent = new Intent(this, Main2Activity.class);
            Bundle bundle=new Bundle();
            SeriBean seriBean = new SeriBean(userDataBeans);
            bundle.putSerializable("user",seriBean);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
            return;
        }

        userDataBeans.add(new UserDataBean(i, useTime, isRifht));


        i++;
        mViewBinding.vp.setCurrentItem(i, false);

    }
}
