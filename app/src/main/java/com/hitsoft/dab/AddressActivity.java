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

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AddressActivity extends Activity {
    /**
     * @查看我发布的商品
     */
    private List<Map<String, Object>> mData;
    private ListView mListView;
    private String message;
    ViewHolder holder = null;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_main);

        mListView=(ListView)findViewById(R.id.addresslist);
        MyAdapter adapter = new MyAdapter(this);
        mListView.setAdapter(adapter);
        mListView.setItemsCanFocus(false);
        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击列表中栏目发生的事件
                message=(String)mData.get(position).get("addtext");
                Intent intent=new Intent(AddressActivity.this,PayActivity.class);
                intent.putExtra(EXTRA_MESSAGE,message);
                startActivity(intent);
            }
        });
    }

    //初始化
    private void init() {
        mData=new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("addtext", "地址1");

        mData.add(map);
        map = new HashMap<String, Object>();
        map.put("addtext", "地址2");

        mData.add(map);
        map = new HashMap<String, Object>();
        map.put("addtext", "地址3");

        mData.add(map);
    }

    public final class ViewHolder{
        public TextView addtext;


    }

    public class MyAdapter extends BaseAdapter{
        private LayoutInflater mInflater;

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
//            ViewHolder holder = null;
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.listbutton2, null);
                holder.addtext = (TextView)convertView.findViewById(R.id.addtext);



                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.addtext.setText((String)mData.get(position).get("addtext"));
//             message=holder.addtext.getText().toString();


            return convertView;
        }

    }
    private Button returnButton;
}