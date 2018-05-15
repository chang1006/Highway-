package com.example.chang.highway;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.register.Login;
import com.example.register.Signin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by chang on 2018/3/6.
 */


public class FirstFragment extends Fragment {
    private String context;
    private TextView mTextView;
    private Button start;
    private Button end;
    private Button btn;
    private int year, month, day;

//    public  FirstFragment(String context){
//        this.context = context;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        start = (Button) view.findViewById(R.id.start);
        end = (Button) view.findViewById(R.id.end);
        btn = (Button) view.findViewById(R.id.btn);

 //       Bundle bundle = getArguments();//从activity传过来的Bundle
//        if(bundle!=null){
//            mArgument = bundle.getString(ID);
//            //start.setText(bundle.getString(ID));
//        }
//        public static FirstFragment newInstance(String idd)
//        {
//            Bundle bundle = new Bundle();
//            bundle.putString(ID, idd);
//            FirstFragment contentFragment = new FirstFragment();
//            contentFragment.setArguments(bundle);
//            return contentFragment;
//        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
        String date = dateFormat.format(new java.util.Date());

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), StartSearch.class);
                //intent.putExtra("starttext",1);
                //startActivity(intent);
                startActivityForResult(intent,1);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date();
                datePickerDialog();
            }
        });

        mTextView = (TextView) view.findViewById(R.id.txt_content);
        //       mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        mTextView.setText(context);
        return view;
    }
        private void datePickerDialog() {
            new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    String date = String.format("%d-%d-%d", year, monthOfYear, dayOfMonth);
                    btn.setText(date);
                }
            }, year, month, day).show();
        }

        //获取当前系统时间
        private void date() {
            Calendar c = Calendar.getInstance();
            //年
            year = c.get(Calendar.YEAR);
            //月
            month = c.get(Calendar.MONTH);
            //日
            day = c.get(Calendar.DAY_OF_MONTH);

        }




    }
