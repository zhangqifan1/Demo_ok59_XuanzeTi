package com.as.demo_ok59_xuanzeti.base_ui.mvp;

import android.content.Context;

/**
 * -----------------------------
 * Created by zqf on 2018/1/22.
 * ---------------------------
 */

public interface BaseIView {
    Context getCt();
    void showLoading();
    void showError();
    void showSuccess();

}
