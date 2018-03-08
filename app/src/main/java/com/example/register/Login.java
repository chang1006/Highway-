package com.example.register;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chang.highway.MainActivity;
import com.example.chang.highway.Person;
import com.example.chang.highway.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by chang on 2018/3/6.
 */

public class Login extends AppCompatActivity{
    private EditText username;
    private EditText password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
		/*
		 * 1.初始化控件
		 * 2.需要一个适配器
		 * 3.初始化数据源
		 * 4.将adpter与当前AutoCompleteTextView绑定
		 */
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // 获取用户输入的用户名和密码
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                // 使用BmobSDK提供的注册功能
                Person user = new Person();
                user.setName(Username);
                user.setAddress(Password);
                user.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (null == e) {
                            Toast.makeText(Login.this, "登陆成功，ObjectId:" + s, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "登陆失败，错误信息：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}