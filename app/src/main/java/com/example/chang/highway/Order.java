package com.example.chang.highway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by chang on 2018/5/21.
 */

public class Order extends AppCompatActivity {
    private TextView start;
    private TextView end;
    private TextView time;
    private TextView licence;
    private TextView type;
    private TextView money;

    private MyApplication myApp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_order);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        time = findViewById(R.id.time);
        licence = findViewById(R.id.licence);
        type = findViewById(R.id.type);
        money = findViewById(R.id.money);

        myApp = (MyApplication)getApplicationContext();
        start.setText(myApp.getAppstart());
        end.setText(myApp.getAppend());
        time.setText(myApp.getApptime());
        licence.setText(myApp.getAppnumber());
        type.setText(myApp.getApptype());


        String starts = start.getText().toString();
        String ends = end.getText().toString();
        String types = type.getText().toString();

        if(starts=="沈阳西"){
        double imoney = 0.35 * 8;
        String smoney = String.valueOf(imoney);
        money.setText(smoney);
        }

//        switch(starts) {
//              case "沈阳西":
//                  double imoney = 0.35 * 8;
//                  String smoney = String.valueOf(imoney);
//                  money.setText(smoney);
//                  break;
//        }



//        double s_imoneyA1_2 = 0.35*8;
//        double s_imoneyA1_3 = 0.35*8;
//        String s_smoneyA1_2 = String.valueOf(s_imoneyA1_2);
//        String s_smoneyA1_3 = String.valueOf(s_imoneyA1_3);
//        switch(starts) {
//            case "沈阳西":
//                money.setText(s_smoneyA1_2);
//                break;
//                switch (ends){
//                    case "红旗台":
//                        money.setText(s_smoneyA1_3);
//                        break;
//                }
//
//            case "二十里铺":;
//                money.setText(s_smoney1_3);
//                break;
//        }

//        if (starts == "沈阳西") {
//            if (ends == "红旗台") {
//                if(types == "≤7座") {
//                    double imoney = 0.35 * 8;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//                else{
//                    double imoney = 0.8 * 8;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//            }
//            else if(ends == "陵园街"){
//                if(types == "≤7座") {
//                    double imoney = 0.35 * 23;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//                else{
//                    double imoney = 0.8 * 23;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//            }
//        }
//        else if(starts == "二十里铺"){
//             if (ends == "沈阳西") {
//                if(types == "≤7座") {
//                    double imoney = 0.35 * 337;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//                else{
//                    double imoney = 0.8 * 337;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//            }
//            else if(ends == "陵园街"){
//                if(types == "≤7座") {
//                    double imoney = 0.35 * 23;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//                else{
//                    double imoney = 0.8 * 23;
//                    String smoney = String.valueOf(imoney);
//                    money.setText(smoney);
//                }
//            }
//        }



    }


}
