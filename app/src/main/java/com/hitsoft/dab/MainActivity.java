package com.hitsoft.dab;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static android.R.attr.rating;
import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends Activity {
    private String[] data = {"apple", "pee", "sss", "hello", "qqq", "hahaha", "gif", "qwer", "abcd", "eddfff", "sssaaa", "fuc", "gun", "gay", "smile"};
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_info);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, data);
        final ListView listView = (ListView) findViewById(R.id.list_view1);
        final RatingBar rat = (RatingBar) findViewById(R.id.rat);
        rat.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                ratingBar.setRating(rating);
                Toast.makeText(MainActivity.this,"rating"+String.valueOf(rating),
                        Toast.LENGTH_LONG);

            }
        });
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("名称")
                        .setMessage("商品详情 ")
                        .setNeutralButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                                // do whatever you want to do
                            }
                        }).show();

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, data);
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
                    Toast.makeText(MainActivity.this, "你点击了设置", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("余额")) {
                    Toast.makeText(MainActivity.this, "你点击了余额", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("地址管理")) {
                    Toast.makeText(MainActivity.this, "你点击了地址管理", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("我的收藏")) {
                    Toast.makeText(MainActivity.this, "你点击了我的收藏", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("通知")) {
                    Toast.makeText(MainActivity.this, "你点击了通知", Toast.LENGTH_SHORT).show();
                }
                if (list.get(arg2).equals("其他")) {
                    Toast.makeText(MainActivity.this, "你点击了其他", Toast.LENGTH_SHORT).show();
                }
            }

        });


        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("商家推荐").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("热销")
                .setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("其他")
                .setContent(R.id.view3));
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public final  class ViewHolder{
        public Button abutton;
        public Button dbutton;
        public EditText e1;
    }
    public class MyAdapter extends BaseAdapter{
        private LayoutInflater mInflater;
        private  MyAdapter(Context context){
            this.mInflater=LayoutInflater.from(context);
            init();

        }

        private void init() {
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if (convertView==null){
                holder=new ViewHolder();
                convertView=mInflater.inflate(R.layout.listbutton,null);
                holder.abutton=(Button)convertView.findViewById(R.id.abutton);
                holder.dbutton=(Button)convertView.findViewById(R.id.dbutton);
                holder.e1=(EditText)convertView.findViewById(R.id.e1);
                convertView.setTag(holder);

            }else{
                holder=(ViewHolder)convertView.getTag();
            }
            holder.abutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            holder.dbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            return convertView;

        }
        private Button returnButton;

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
