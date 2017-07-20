package com.hitsoft.dab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeActivity extends Activity {
    private String[] data = {"apple", "pee", "sss", "hello", "qqq", "hahaha", "gif", "qwer", "abcd", "eddfff", "sssaaa", "fuc", "gun", "gay", "smile"};
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    private Button button1 = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.button1 = (Button) super.findViewById(R.id.button1);
        button1.setOnClickListener(new button1OnClickListenerImpl());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                HomeActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view1);
        listView.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                HomeActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView2 = (ListView) findViewById(R.id.list_view2);
        listView2.setAdapter(adapter2);


        mylistview = (ListView) findViewById(R.id.list_view3);
        list.add("设置");
        list.add("余额");
        list.add("地址管理");
        list.add("我的收藏");
        list.add("通知");
        list.add("其他");
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);
        mylistview.setAdapter(myArrayAdapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (list.get(arg2).equals("设置")) {
                    Toast.makeText(HomeActivity.this, "你点击了设置", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("余额")) {
                    Toast.makeText(HomeActivity.this, "你点击了余额", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("地址管理")) {
                    Toast.makeText(HomeActivity.this, "你点击了地址管理", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("我的收藏")) {
                    Toast.makeText(HomeActivity.this, "你点击了我的收藏", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("通知")) {
                    Toast.makeText(HomeActivity.this, "你点击了通知", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("其他")) {
                    Toast.makeText(HomeActivity.this, "你点击了其他", Toast.LENGTH_SHORT).show();
                }
            }

        });
        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("外卖").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("订单")
                .setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("我的")
                .setContent(R.id.view3));
    }

    private class button1OnClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(HomeActivity.this,MapActivity.class);
            startActivity(intent);
        }

    }
}
