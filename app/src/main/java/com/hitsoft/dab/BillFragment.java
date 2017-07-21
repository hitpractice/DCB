package com.hitsoft.dab;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/20.
 */
public class BillFragment extends Fragment {
    private String[] data = {"apple", "pee", "sss", "hello", "qqq", "hahaha", "gif", "qwer", "abcd", "eddfff", "sssaaa", "fuc", "gun", "gay", "smile"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View BillLayout = inflater.inflate(R.layout.bill_layout, container, false);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, data);
        ListView listView2 = (ListView) BillLayout.findViewById(R.id.list_view2);
        listView2.setAdapter(adapter2);

        return BillLayout;
    }

}