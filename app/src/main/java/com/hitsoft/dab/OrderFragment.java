package com.hitsoft.dab;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/7/20.
 */
public class OrderFragment extends Fragment {
    private Button button1 = null;
    private String[] data = {"apple", "pee", "sss", "hello", "qqq", "hahaha", "gif", "qwer", "abcd", "eddfff", "sssaaa", "fuc", "gun", "gay", "smile"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View OrderLayout = inflater.inflate(R.layout.order_layout, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) OrderLayout.findViewById(R.id.list_view1);
        listView.setAdapter(adapter);

        this.button1 = (Button)OrderLayout.findViewById(R.id.button1);
        button1.setOnClickListener(new button1OnClickListenerImpl());

        return OrderLayout;
    }
    private class button1OnClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(getActivity(),MapActivity.class);
            startActivity(intent);
        }

    }

}
