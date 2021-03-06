package com.hitsoft.dab;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/7/20.
 */
public class MyFragment extends Fragment{
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View MyLayout = inflater.inflate(R.layout.my_layout, container, false);

        mylistview = (ListView) MyLayout.findViewById(R.id.list_view3);
        list.add("设置");
        list.add("余额");
        list.add("地址管理");
        list.add("我的收藏");
        list.add("通知");
        list.add("其他");
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, list);
        mylistview.setAdapter(myArrayAdapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (list.get(arg2).equals("设置")) {
                    Intent intent = new Intent(getActivity(),SettingActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("余额")) {
                    Intent intent = new Intent(getActivity(),MoneyActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("地址管理")) {
                    Intent intent = new Intent(getActivity(),AddressActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("我的收藏")) {
                    Intent intent = new Intent(getActivity(),LikeActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("通知")) {
                    Intent intent = new Intent(getActivity(),MessageActivity.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("其他")) {
                    Toast.makeText(getActivity(), "暂未开发", Toast.LENGTH_SHORT).show();
                }
            }

        });
        return MyLayout;
    }

}