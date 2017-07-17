package com.hitsoft.dab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TabHost tabHost=(TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("特价").setContent(R.id.View1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("推荐").setContent(R.id.View2));
    }
}
