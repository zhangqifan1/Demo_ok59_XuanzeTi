package com.as.demo_ok59_xuanzeti;

import android.app.Application;

import com.luliang.shapeutils.DevShapeUtils;

/**
 * -----------------------------
 * Created by zqf on 2019/12/17.
 * ---------------------------
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DevShapeUtils.init(this);
    }
}
