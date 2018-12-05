package com.bwie.day20181205.mvp;

/**
 * author：张腾
 * date：2018/12/5
 */
public interface LoginView {
    void onLoginSuccess(String result);
    void onLoginFailer(String msg);
}
