package com.hitsoft.dab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * @查看我发布的商品
     */
    private List<Map<String, Object>> mData;
    private ListView mListView;
    private Button sure;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_info);
        this.sure=(Button)findViewById(R.id.sure);
        sure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PayActivity.class);
                startActivity(intent);
            }
        });
        mListView=(ListView)findViewById(R.id.lv);

        MyAdapter adapter = new MyAdapter(this);
        mListView.setAdapter(adapter);
        mListView.setItemsCanFocus(false);
        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击列表中栏目发生的事件
                Toast.makeText(MainActivity.this, "商品描述：" + (String)mData.get(position).get("gooddescription"), Toast.LENGTH_LONG).show();
            }
        });
    }

    //初始化
    private void init() {
        mData=new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("goodname", "商品1");
        map.put("goodprice", "10元");
        map.put("goodlocation", "  ");
        map.put("gooddescription", "google 1");
        mData.add(map);
        map = new HashMap<String, Object>();
        map.put("goodname", "商品2");
        map.put("goodprice", "12元");
        map.put("goodlocation", "  ");
        map.put("gooddescription", "google 1");
        mData.add(map);
        map = new HashMap<String, Object>();
        map.put("goodname", "商品3");
        map.put("goodprice", "30元");
        map.put("goodlocation", "  ");
        map.put("gooddescription", "google 3");
        mData.add(map);
    }

    public final class ViewHolder{
        public TextView goodname;
        public TextView goodprice;
        public TextView goodlocation;
        public Button delectButton;
        public Button addButton;
        public TextView num;
        private ImageView p1;

    }

    public class MyAdapter extends BaseAdapter{
        private LayoutInflater mInflater;
        public int a;

        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
            init();
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.listbutton, null);
                holder.goodname = (TextView)convertView.findViewById(R.id.goodname);
                holder.goodprice = (TextView)convertView.findViewById(R.id.goodprice);
                holder.goodlocation = (TextView)convertView.findViewById(R.id.goodlocation);
                holder.delectButton = (Button)convertView.findViewById(R.id.delectButton);
                holder.addButton = (Button)convertView.findViewById(R.id.addButton);
                holder.p1=(ImageView)convertView.findViewById(R.id.p1);
                holder.num=(TextView)convertView.findViewById(R.id.num);



                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.goodname.setText((String)mData.get(position).get("goodname"));
            holder.goodprice.setText((String)mData.get(position).get("goodprice"));
            holder.goodlocation.setText((String)mData.get(position).get("goodlocation"));
            holder.num.setText(a+"");
            holder.delectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //减少c商品

                    if (a>0){
                    a=a-1;
                    }else {
                        a=2;
                    }

                }
            });
            holder.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //增加商品信息
                    a=a+1;
                }
            });
            return convertView;
        }
    }
    private Button returnButton;
}