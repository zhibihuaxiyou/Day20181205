package com.bwie.day20181205.mvp;


import com.bwie.day20181205.LoginCallBack;
import com.bwie.day20181205.bean.LoginBean;
import com.bwie.day20181205.utils.HttpHelper;
import com.google.gson.Gson;

/**
 * author：张腾
 * date：2018/12/5
 */
public class LoginModelIpl {

    public void login(String username, String password, final LoginCallBack loginCallBack){
        final String LOGINURL = "http://www.xieast.com/api/user/login.php?username="+username+"&password="+password;
        new HttpHelper().get(LOGINURL).result(new HttpHelper.HttpListener() {
            @Override
            public void success(String data) {
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(data, LoginBean.class);
                if (loginBean.getCode() == 100) {
                    loginCallBack.onSuccess(loginBean.getMsg());
                }else {
                    loginCallBack.onFailer(loginBean.getMsg());
                }
            }

            @Override
            public void fail() {
                loginCallBack.onFailer("解析失败");
            }
        });
//        if (username.equals("13800138000")&&password.equals("123456")) {
//            loginCallBack.onSuccess("登录成功");
//        }else {
//            loginCallBack.onFailer("登录失败");
//        }

    }
}
