package com.hitsoft.dab;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrator on 2017/7/24.
 */

public class SettingActivity extends Activity {
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    private EditText et_change = null;
    private EditText et_changephonenumber = null;
    private EditText et_changepw1 = null;
    private EditText et_changepw2 = null;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mylistview = (ListView) this.findViewById(R.id.list_view5);
        list.add("头像");
        list.add("昵称");
        list.add("密码");
        list.add("手机");

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);
        mylistview.setAdapter(myArrayAdapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (list.get(arg2).equals("头像")) {
                   // Intent intent = new Intent();
		        /* 开启Pictures画面Type设定为image */
                  //  intent.setType("image/*");
		        /* 使用Intent.ACTION_GET_CONTENT这个Action */
                   // intent.setAction(Intent.ACTION_GET_CONTENT);
		        /* 取得相片后返回本画面 */
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		        startActivityForResult(intent, 1);

                }
                if (list.get(arg2).equals("昵称")) {
                    change();
                }
                if (list.get(arg2).equals("密码")) {
                    changepw();
                }
                if (list.get(arg2).equals("手机")) {
                    changephonenumber();
                }
            }

        });

    }
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Log.e("uri", uri.toString());
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                ImageView imageView = (ImageView) findViewById(R.id.iv01);

                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			String sdStatus = Environment.getExternalStorageState();
			if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
				Log.i("TestFile",
						"SD card is not avaiable/writeable right now.");
				return;
			}
			String name = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
			Toast.makeText(this, name, Toast.LENGTH_LONG).show();
			Bundle bundle = data.getExtras();
			Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

			FileOutputStream b = null;
			File file = new File("/sdcard/myImage/");
			file.mkdirs();// 创建文件夹
			String fileName = "/sdcard/myImage/"+name;

			try {
				b = new FileOutputStream(fileName);
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					b.flush();
					b.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			((ImageView) findViewById(R.id.iv01)).setImageBitmap(bitmap);// 将图片显示在ImageView里
		}
	}
    public void change() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.dialogview, null);
        dialog.setView(layout);
        et_change = (EditText)layout.findViewById(R.id.change);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (et_change.getText().toString().length()<4){
                Toast.makeText(SettingActivity.this,"更改失败：昵称太短",Toast.LENGTH_SHORT).show();
                }else if(et_change.getText().toString().indexOf(" ")!=-1){
                    Toast.makeText(SettingActivity.this,"更改失败：昵称不能包含空格",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SettingActivity.this,"更改成功",Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }

        });
        dialog.show();
    }

    public void changephonenumber() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.dialogview2, null);
        dialog.setView(layout);
        et_changephonenumber = (EditText)layout.findViewById(R.id.changephonenumber);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int x = et_changephonenumber.getText().length();
                if(x==11){
                    Toast.makeText(SettingActivity.this,"更改成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SettingActivity.this,"更改失败：不是正确的手机号码",Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }

        });
        dialog.show();
    }

    public void changepw() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.dialogview3, null);
        dialog.setView(layout);
        et_changepw1 = (EditText)layout.findViewById(R.id.changepw1);
        et_changepw2 = (EditText)layout.findViewById(R.id.changepw2);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if(et_changepw1.getText().toString().equals(et_changepw2.getText().toString())&&et_changepw1.getText().toString().length()>=8){
                    Toast.makeText(SettingActivity.this,"更改成功",Toast.LENGTH_SHORT).show();
                }else if(et_changepw1.getText().toString().indexOf(" ")!=-1){
                    Toast.makeText(SettingActivity.this,"更改失败：密码中不能包含空格",Toast.LENGTH_SHORT).show();
                }else if (et_changepw1.getText().toString().length()<8){
                    Toast.makeText(SettingActivity.this,"更改失败：密码太短",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SettingActivity.this,"更改失败：前后输入的密码不一致",Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }

        });
        dialog.show();
    }


}
