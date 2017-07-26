package com.hitsoft.dab;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20.
 */
public class OrderFragment extends Fragment {

    private ImageButton button1 = null;
    public static String searchkeyword;
    private EditText edit1 = null;
    private ImageButton button2 = null;

    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.mipmap.if_1, R.mipmap.if_2,
            R.mipmap.if_3, R.mipmap.if_4, R.mipmap.if_5,
            R.mipmap.if_6, R.mipmap.if_7, R.mipmap.if_8};
    private String[] iconName = {"便当简餐", "拉面米线", "汉堡薯条", "奶茶蛋糕", "异国料理", "包子粥店", "火锅烧烤",
            "果蔬生鲜"};


    private String[] data = {"老五烧烤7", "老五早餐6", "麦当劳3", "南岗盖饭1", "AB便当1", "鲜果时光4", "G蛋糕店4", "张三包子6", "兰州拉面2", "肯德基3", "FFF寿司5", "老王水果店8", "AAA盒饭1", "B韩式炸鸡5", "R便当1"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View OrderLayout = inflater.inflate(R.layout.order_layout, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) OrderLayout.findViewById(R.id.list_view1);
        listView.setAdapter(adapter);

        this.button1 = (ImageButton) OrderLayout.findViewById(R.id.button1);
        button1.setOnClickListener(new button1OnClickListenerImpl());

        this.edit1 = (EditText) OrderLayout.findViewById(R.id.edit1);

        this.button2 = (ImageButton) OrderLayout.findViewById(R.id.button2);
        button2.setOnClickListener(new button2OnClickListenerImpl());

        gview = (GridView) OrderLayout.findViewById(R.id.gview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.search_image, R.id.search_text};
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.order_item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (id == 0) {
                    searchkeyword = "1";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 1) {
                    searchkeyword = "2";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 2) {
                    searchkeyword = "3";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 3) {
                    searchkeyword = "4";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 4) {
                    searchkeyword = "5";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 5) {
                    searchkeyword = "6";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 6) {
                    searchkeyword = "7";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
                if (id == 7) {
                    searchkeyword = "8";
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent);
                }
            }
        });
        return OrderLayout;
    }

    //定位按钮
    private class button1OnClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(getActivity(), MapActivity.class);
            startActivity(intent);
        }

    }

    //搜索图片按钮
    private class button2OnClickListenerImpl implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            searchkeyword = edit1.getText().toString().replace(" ","");
            if (searchkeyword.equals("")) {
                Toast.makeText(getActivity(), "请输入搜索内容", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        }

    }

    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

}
