package com.hitsoft.dab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressLint("NewApi")
public class UserRegister extends Activity implements OnClickListener {
    private SQLiteDatabase database;
    private SQLiteOpenHelper helper = null;
    private MytabOperate mtab = null;
    private EditText register_username;//用户名
    private EditText register_passwd;//密码
    private EditText reregister_passwd;//重复输入密码
    private Button register_submit;//注册

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        SQLiteOpenHelper helper = new MyDatabaseHelper(this);
        this.helper = helper;
        // .getWritableDatabase();
        setContentView(R.layout.user_register);

        this.register_username = (EditText) findViewById(R.id.register_username);
        this.register_passwd = (EditText) findViewById(R.id.register_passwd);
        this.reregister_passwd = (EditText) findViewById(R.id.reregister_passwd);
        this.register_submit = (Button) findViewById(R.id.register_submit);
        this.register_submit
                .setOnClickListener(new InsertOnClickListenerImpl());
        this.register_username.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            //用户名不能小于四个字符
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (!hasFocus) {
                    if (register_username.getText().toString().trim().length() < 4) {
                        Toast.makeText(UserRegister.this, "用户名不能小于4个字符",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        //密码不能小于8个字符
        this.register_passwd.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (!hasFocus) {
                    if (register_passwd.getText().toString().trim().length() < 6) {
                        Toast.makeText(UserRegister.this, "密码不能小于8个字符",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        //判断两次密码输入不一致
        this.reregister_passwd.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (!hasFocus) {
                    if (!reregister_passwd
                            .getText()
                            .toString()
                            .trim()
                            .equals(register_passwd.getText().toString().trim())) {
                        Toast.makeText(UserRegister.this, "两次密码输入不一致",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }
    //判断密码、用户名不为空
    private boolean checkEdit() {
        if (register_username.getText().toString().trim().equals("")) {
            Toast.makeText(UserRegister.this, "用户名不能为空", Toast.LENGTH_SHORT)
                    .show();
        } else if (register_passwd.getText().toString().trim().equals("")) {
            Toast.makeText(UserRegister.this, "密码不能为空", Toast.LENGTH_SHORT)
                    .show();
        } else {
            return true;
        }
        return false;
    }

    private class InsertOnClickListenerImpl implements OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            String user = UserRegister.this.register_username.getText()
                    .toString();
            String password = UserRegister.this.register_passwd.getText()
                    .toString();
            //判断是否存在用户名小于四个字符、密码小于8个字符、两次密码输入不一致、密码、用户名为空
            if (register_username.getText().toString().trim().length() < 4
                    || register_passwd.getText().toString().trim().length() < 6
                    || !reregister_passwd
                    .getText()
                    .toString()
                    .trim()
                    .equals(register_passwd.getText().toString().trim())
                    || register_username.getText().toString().trim().equals("")
                    || register_passwd.getText().toString().trim().equals("")) {
                Toast myToast = Toast.makeText(UserRegister.this, "注册失败",
                        Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.CENTER, 60, 30);
                LinearLayout myToastView = (LinearLayout) myToast.getView();
                ImageView img = new ImageView(UserRegister.this);
                img.setImageResource(R.drawable.successlogo);
                myToastView.addView(img);
                myToast.show();
                Intent intent = new Intent(UserRegister.this,
                        UserRegister.class);
                startActivity(intent);//存在，注册失败，重新注册
            } else {
                Toast myToast = Toast.makeText(UserRegister.this, "注册成功",
                        Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.CENTER, 60, 30);
                LinearLayout myToastView = (LinearLayout) myToast.getView();
                ImageView img = new ImageView(UserRegister.this);
                img.setImageResource(R.drawable.successlogo);
                myToastView.addView(img);
                myToast.show();
                Intent intent = new Intent(UserRegister.this, UserLogin.class);
                startActivity(intent);//不存在，注册成功，自动跳转到登陆界面
                UserRegister.this.mtab = new MytabOperate(
                        UserRegister.this.helper.getWritableDatabase());
                UserRegister.this.mtab.insert2(user, password);
            }
            UserRegister.this.finish();
        }

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }

}
