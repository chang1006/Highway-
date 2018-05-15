package com.example.chang.highway;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by chang on 2018/3/20.
 */

public class StartSearch extends AppCompatActivity {

    private EditText startsearch;
    private Button ensure;
    private EditText start;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private List<String> list = new ArrayList<String>();
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_search);
        startsearch = (EditText) findViewById(R.id.startsearch);
        ensure = (Button)findViewById(R.id.ensure);

        manager = getFragmentManager();
//        transaction = manager.beginTransaction();
//
//        transaction.add(R.id.fragment_container, new FirstFragment());
//        transaction.commit();

        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String Startsearch = startsearch.getText().toString();
                if(Startsearch.equals("")){
                    Toast.makeText(StartSearch.this, "请选择入口", Toast.LENGTH_LONG).show();
                    return;
                }
                String str = startsearch.getText().toString();
                Intent intent = new Intent(StartSearch.this, MainActivity.class);
                intent.putExtra("id",str);
                startActivityForResult(intent,1000);

//                Intent intent1 = new Intent(StartSearch.this,MainActivity.class);
//                String result = StartSearch.this.getIntent().getStringExtra("result");
//                intent1.putExtra("result", result);
//                startActivity(intent1);

                FirstFragment firstFragment = new FirstFragment();
                Bundle bundle = new Bundle();
                bundle.putString("str",Startsearch);//这里的values就是我们要传的值
                firstFragment.setArguments(bundle);
//                transaction = manager.beginTransaction();
//                transaction.replace(R.id.fragment_container, firstFragment);
//                transaction.commit();

            }
        });
        startsearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
//如果actionId是搜索的id，则进行下一步的操作
                    ShowDialog();
         //           list = initData();
                }
                return false;
            }
            //初始化数据
//            private ArrayList<String> initData() {
// //               String[] data = {"1","2","3","4"};
////                ArrayAdapter<String>adapter = new ArrayAdapter<String>(
////                        StartSearch.this,android.R.layout.simple_list_item_1,data);
////                ListView listView = findViewById(R.id.formcustomspinner_list);
////                listView.setAdapter(adapter);
//               ArrayList<String> list = new ArrayList<String>();
//                for(int i = 0;i < 15;i++){
//                    String name = "布丁布丁"+i;
//                    list.add(name+"233");
//                }
//                return list;
//            }
            public void ShowDialog() {
                Context context = StartSearch.this;
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.search_list, null);
                String[] list = {"1","2","3","4"};
                ListView myListView = (ListView) layout.findViewById(R.id.formcustomspinner_list);
                ArrayAdapter<String>adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,list);
                // MyAdapter adapter = new MyAdapter(context, list);
                myListView.setAdapter(adapter);
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                        //在这里面就是执行点击后要进行的操作,这里只是做一个显示
                        String mlist = arg0.getItemAtPosition(position).toString();
                        startsearch.setText(mlist);
//                        Toast.makeText(StartSearch.this, "您点击的是"+mlist, Toast.LENGTH_SHORT).show();
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                    }
                });
                builder = new AlertDialog.Builder(context);
                builder.setView(layout);
                alertDialog = builder.create();
                alertDialog.show();
            }
//            class MyAdapter extends BaseAdapter {
//                private List<String> mlist;
//                private Context mContext;
//
//                public MyAdapter(Context context, List<String> list) {
//                    this.mContext = context;
//                    mlist = new ArrayList<String>();
//                    this.mlist = list;
//                }
//
//                @Override
//                public int getCount() {
//                    return mlist.size();
//                }
//
//                @Override
//                public Object getItem(int position) {
//                    return mlist.get(position);
//                }
//
//                @Override
//                public long getItemId(int position) {
//                    return position;
//                }
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    Person person = null;
//                    if (convertView == null) {
//                        LayoutInflater inflater = LayoutInflater.from(mContext);
//                        convertView = inflater.inflate(R.layout.rtu_item,null);
//                        person = new Person();
//                        person.name = (TextView)convertView.findViewById(R.id.tv_name);
//                        convertView.setTag(person);
//                    }else{
//                        person = (Person)convertView.getTag();
//                    }
//                    person.name.setText(list.get(position).toString());
//                    return convertView;
//                }
//                class Person{
//                    TextView name;
//                }
//            }
        });



    }
}





