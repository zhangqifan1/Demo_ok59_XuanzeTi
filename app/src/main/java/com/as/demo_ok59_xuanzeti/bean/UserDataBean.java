package com.as.demo_ok59_xuanzeti.bean;

import java.io.Serializable;

/**
 * -----------------------------
 * Created by zqf on 2019/12/17.
 * ---------------------------
 */
public class UserDataBean implements Serializable {
    private int  usetime;
    private int question;
    private boolean isRight;

    public UserDataBean( int question, int usetime,boolean isRight) {
        this.usetime = usetime;
        this.question = question;
        this.isRight = isRight;
    }

    public int getUsetime() {
        return usetime;
    }

    public void setUsetime(int usetime) {
        this.usetime = usetime;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    @Override
    public String toString() {
        return "UserDataBean{" +
                "用时=" + usetime +
                "秒, question=" + question +
                ", isRight=" + isRight +
                '}';
    }
}
