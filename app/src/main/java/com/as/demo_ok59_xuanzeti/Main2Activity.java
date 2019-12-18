package com.as.demo_ok59_xuanzeti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.as.demo_ok59_xuanzeti.bean.SeriBean;
import com.as.demo_ok59_xuanzeti.bean.UserDataBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private boolean isSelect = false;
    private Map<Integer, Boolean> map = new HashMap<>();;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        LinearLayout linearLayout = findViewById(R.id.root);
//
//        SeriBean user = (SeriBean) getIntent().getExtras().getSerializable("user");
//
//        List<UserDataBean> list = user.getList();
//        for (int i = 0; i < list.size(); i++) {
//            TextView textView = new TextView(this);
//            textView.setText(list.get(i).toString());
//            linearLayout.addView(textView);
//        }


        List<String> list = new ArrayList<String>() {{
            for (int i = 0; i < 20; i++) {
                add("第" + i + "条");
            }
        }};

        RecyclerView recyclerView = findViewById(R.id.rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        Rv2Adapter rv2Adapter = new Rv2Adapter(R.layout.item2, list);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(rv2Adapter);



        for (int i = 0; i < list.size(); i++) {
            map.put(i, false);
        }

        rv2Adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                boolean aBoolean = map.get(position);
                ToastUtils.showShort(""+aBoolean);
                map.put(position, !aBoolean);

                View bg_item = view.findViewById(R.id.bg_item);
                TextView tv_item = view.findViewById(R.id.tv_item);

                if (aBoolean) {

                    DevShapeUtils.shape(DevShape.RECTANGLE)
                            .radius(20)
//                            .line(1, "#000000")
                            .solid(R.color.hui)
                            .into(bg_item);

                    bg_item.setElevation(0);

                    tv_item.setTextColor(getResources().getColor(R.color.black));

                } else {

                    DevShapeUtils.shape(DevShape.RECTANGLE)
                            .radius(20)
//                            .line(1, "#000000")
                            .solid("#FFFFFF")
                            .into(bg_item);

                    bg_item.setElevation(20);

                    tv_item.setTextColor(getResources().getColor(R.color.cheng));

                }
            }
        });



    }
}
