package com.hitsoft.dab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class UserLogin extends Activity implements OnClickListener {
    private EditText login_username;// 用户名
    private EditText login_password;// 密码
    private Button user_login_button;// 登录
    private Button user_register_button;// 注册
    private Button unregister_login_button;// 游客登录

    private SQLiteDatabase database;
    private SQLiteOpenHelper helper = null;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.user_login);
        initWidget();
        SQLiteOpenHelper helper = new MyDatabaseHelper(this);
        this.helper = helper;












    }

    private void initWidget() {
        this.login_username = (EditText) findViewById(R.id.login_username);
        this.login_password = (EditText) findViewById(R.id.login_password);
        this.user_login_button = (Button) findViewById(R.id.user_login_button);
        this.user_register_button = (Button) findViewById(R.id.user_register_button);
        this.unregister_login_button = (Button) findViewById(R.id.unregister_login_button);
        this.user_login_button.setOnClickListener(this);

        this.user_login_button.setOnClickListener(new OnClickListenerImpl());

        this.user_register_button.setOnClickListener(new ReOnClickListenerImpl());
        this.login_username.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            //用户名不能小于4个字符
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (!hasFocus) {
                    String username = login_username.getText().toString()
                            .trim();
                    if (username.length() < 4) {
                        Toast.makeText(UserLogin.this, "用户名不能小于4个字符",
                                Toast.LENGTH_SHORT);
                    }
                }
            }

        });
        //密码不能小于4个字符
        this.login_password.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (!hasFocus) {
                    String password = login_password.getText().toString()
                            .trim();
                    if (password.length() < 4) {
                        Toast.makeText(UserLogin.this, "密码不能小于4个字符",
                                Toast.LENGTH_SHORT);
                    }
                }
            }

        });
    }
    //用户名不能为空，密码不能为空
    private boolean checkEdit() {
        if (login_username.getText().toString().trim().equals("")) {
            Toast.makeText(UserLogin.this, "用户名不能为空", Toast.LENGTH_SHORT)
                    .show();
        } else if (login_password.getText().toString().trim().equals("")) {
            Toast.makeText(UserLogin.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            return true;
        }
        return false;
    }
    //点击注册按钮，从登陆页面跳转到注册页面
    private class ReOnClickListenerImpl implements OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(UserLogin.this, UserRegister.class);
            startActivity(intent);
        }

    }

    //验证用户名密码，正确后，成功登陆跳转页面
    private class OnClickListenerImpl implements OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub

            database = new MyDatabaseHelper(UserLogin.this)
                    .getReadableDatabase();
            String user2 = UserLogin.this.login_username.getText().toString();
            String password = UserLogin.this.login_password.getText()
                    .toString();
            String sql = "select user from zhuce where password=?";
            String result = null;
            Cursor cursor = database.rawQuery(sql,
                    new String[] { login_password.getText().toString() });
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                result = cursor.getString(cursor.getColumnIndex("user"));
                Log.d("11", result + user2);
                //判断输入的用户名是否与注册的用户名一致
                if (result.equals(user2)) {
                    Toast myToast = Toast.makeText(UserLogin.this, "登录成功",
                            Toast.LENGTH_SHORT);
                    myToast.setGravity(Gravity.CENTER, 60, 30);
                    LinearLayout myToastView = (LinearLayout) myToast.getView();
                    ImageView img = new ImageView(UserLogin.this);
                    img.setImageResource(R.drawable.successlogo);

                   //一致，成功登陆
                } else {
                    Toast myToast = Toast.makeText(UserLogin.this, "登录失败",
                            Toast.LENGTH_SHORT);
                    myToast.setGravity(Gravity.CENTER, 60, 30);
                    LinearLayout myToastView = (LinearLayout) myToast.getView();
                    ImageView img = new ImageView(UserLogin.this);
                    img.setImageResource(R.drawable.successlogo);
                    myToastView.addView(img);
                    myToast.show();//不一致，登录失败

                }

            }

        }
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }
}