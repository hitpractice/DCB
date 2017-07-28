package com.hitsoft.dab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Administrator on 2017/7/24.
 */

public class PayActivity extends Activity {
    private Button address;
    private TextView addview;
    @Override
    protected  void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_main);


        this.address=(Button)findViewById(R.id.address);
        Intent intent=getIntent();
        String message=intent.getStringExtra(EXTRA_MESSAGE);
        this.addview=(TextView)findViewById(R.id.addview);
        addview.setText(message);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PayActivity.this,AddressActivity.class);
                startActivity(intent);
            }
        });


    }
}
