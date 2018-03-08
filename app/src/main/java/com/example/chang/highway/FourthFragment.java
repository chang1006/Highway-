package com.example.chang.highway;

/**
 * Created by chang on 2018/3/6.
 */

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.register.Login;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class FourthFragment extends Fragment {


    private TextView button1;
    private Button button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourth_fragment,container,false);
        button1 = (TextView)view.findViewById(R.id.txt_content);
        button2 = (Button)view.findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //在当前onClick方法中监听点击button
                //显示intent
                Intent intent = new Intent("com.example.chang.highway.ACTION_START");
                startActivity(intent);
                System.out.println("hhhh");
                Log.i("tag","hhhh");//收集log日志
            }
        });
        //       mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
//        button2.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View arg1) {
//                //在当前onClick方法中监听点击button
//                //显示intent
//                Person user = new Person();
//                user.setName("chang");
//                user.setAddress("123456");
//                user.save(new SaveListener<String>() {
//                    @Override
//                    public void done(String s, BmobException e) {
////                        if (e == null) {
////                            Toast.makeText(FourthFragment.this, "数据上传成功，ObjectId:" + s, Toast.LENGTH_SHORT).show();
////                        } else {
////                            Toast.makeText(FourthFragment.this, "数据上传失败，错误信息：" + e.getMessage(), Toast.LENGTH_SHORT).show();
////                        }
//                    }
//                });

 ////           }
 ////       });
        return view;
    }
}