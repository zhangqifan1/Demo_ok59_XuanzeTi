package com.as.demo_ok59_xuanzeti.bean;

import java.io.Serializable;
import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/12/17.
 * ---------------------------
 */
public class SeriBean implements Serializable {
    private List<UserDataBean> list;

    public SeriBean(List<UserDataBean> list) {
        this.list = list;
    }

    public List<UserDataBean> getList() {
        return list;
    }

    public void setList(List<UserDataBean> list) {
        this.list = list;
    }
}
