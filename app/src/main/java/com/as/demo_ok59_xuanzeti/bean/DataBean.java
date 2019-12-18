package com.as.demo_ok59_xuanzeti.bean;

import java.io.Serializable;
import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/12/17.
 * ---------------------------
 */
public class DataBean implements Serializable {

    //题 : 标题
    private String title;
    // 题 : 四个选项
    private List<String> contents;
    // 正确选项
    private int rightChoose;

    //时间   : 可以不写


    public DataBean(String title, List<String> contents, int rightChoose) {
        this.title = title;
        this.contents = contents;
        this.rightChoose = rightChoose;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    public int getRightChoose() {
        return rightChoose;
    }

    public void setRightChoose(int rightChoose) {
        this.rightChoose = rightChoose;
    }
}
