package com.hitsoft.dab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.hitsoft.dab.OrderFragment.searchkeyword;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SearchActivity extends Activity {
    private String[] data = {"老五烧烤7", "老五早餐6", "麦当劳3", "南岗盖饭1", "AB便当1", "鲜果时光4", "G蛋糕店4", "张三包子6", "兰州拉面2", "肯德基3", "FFF寿司5", "老王水果店8", "AAA盒饭1", "B韩式炸鸡5", "R便当1"};
    private String[] newdata = new String[100];
    private TextView search_keyword = null;
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    int j =0;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        this.search_keyword = (TextView)findViewById(R.id.search_keyword);
        search_keyword.setText("关键词为："+searchkeyword);

        mylistview = (ListView) findViewById(R.id.list_view4);
        for (int i=0;i<data.length;i++){
            int index = data[i].indexOf(searchkeyword);
            if(index!=-1){
                    newdata[j]=data[i];
                    list.add(newdata[j]);
                    j++;
            }
        }
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);
        mylistview.setAdapter(myArrayAdapter);



    }
}
