package com.bwie.day20181205;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.day20181205.mvp.LoginPresenter;
import com.bwie.day20181205.mvp.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    private EditText mEditUserName;
    private EditText mEditPassword;
    private Button mBtnLogin;
    private String username;
    private String password;
    private SharedPreferences sp;
    private CheckBox mCheckbox;
    private CheckBox mCheckboxLogin;
    private SharedPreferences.Editor editor;
    private boolean auto_ischeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresenter = new LoginPresenter(this);
        sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean isChecked = sp.getBoolean("isChecked", false);
        auto_ischeck = sp.getBoolean("AUTO_ISCHECK", false);
        editor = sp.edit();

        if (isChecked) {
            String username = sp.getString("name","");
            String password = sp.getString("pwd","");
            mEditUserName.setText(username);
            mEditPassword.setText(password);
            mCheckbox.setChecked(true);
            if (auto_ischeck) {
                mCheckboxLogin.setChecked(true);
                Intent intent = new Intent(this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        }
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = mEditUserName.getText().toString().trim();
                password = mEditPassword.getText().toString().trim();
                loginPresenter.login(username, password);
            }
        });

        mCheckboxLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCheckboxLogin.isChecked()) {
                    editor.putBoolean("AUTO_ISCHECK",true).commit();
                }else {
                    editor.putBoolean("AUTO_ISCHECK",false).commit();
                }
            }
        });
    }

    private void initView() {
        mEditUserName = findViewById(R.id.edit_username);
        mEditPassword = findViewById(R.id.edit_password);
        mCheckbox = findViewById(R.id.checkbox);
        mCheckboxLogin = findViewById(R.id.checkbox_login);
        mBtnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void onLoginSuccess(String result) {
        if (mCheckbox.isChecked()) {
            editor.putBoolean("isChecked",true);
            editor.putString("name",username);
            editor.putString("pwd",password);
            editor.commit();
        }
        Intent intent = new Intent(this, ShowActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailer(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }

    public void setChuanzhi(boolean auto_ischeck){
        this.auto_ischeck = auto_ischeck;
    }
}
