package com.bwie.day20181205.mvp;

import com.bwie.day20181205.LoginCallBack;

/**
 * author：张腾
 * date：2018/12/5
 */
public class LoginPresenter {
    public LoginModelIpl loginModel;
    public LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        loginModel = new LoginModelIpl();
    }

    public void detachView(){
        if (loginView!=null) {
            loginView = null;
        }

        if (loginModel!=null) {
            loginModel = null;
        }

    }

    public void login(String username,String password){
        loginModel.login(username, password, new LoginCallBack() {
            @Override
            public void onSuccess(String result) {
                loginView.onLoginSuccess(result);
            }

            @Override
            public void onFailer(String msg) {
                loginView.onLoginFailer(msg);
            }
        });
    }
}
