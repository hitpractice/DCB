package com.hitsoft.dab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASENAME="xxx.db";   //数据库名字kkkk
    private static final int DATABASEVERSION=2;     //数据库版本
    private static final String TABLENAME1="restaurant";     //表的名字
    private static final String TABLENAME2="dingdan";
    private static final String TABLENAME3="user";//表的名字


    public MyDatabaseHelper(Context context) {      //第一次使用数据库才会调用此方法
        super(context, DATABASENAME, null, DATABASEVERSION);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        String sql="CREATE TABLE "+TABLENAME1+"("+"id INTEGER PRIMARY KEY,"+"word VARCHAR(100) NOT NULL,"+"chinese VARCHAR(100) NOT NULL"+")";
        arg0.execSQL(sql);
        sql="CREATE TABLE "+TABLENAME2+"("+"id INTEGER PRIMARY KEY,"+"word VARCHAR(100) NOT NULL,"+"chinese VARCHAR(100) NOT NULL"+")";
        arg0.execSQL(sql);               //执行sql
        sql="CREATE TABLE "+TABLENAME3+"("+"id INTEGER PRIMARY KEY,"+"user VARCHAR(100) NOT NULL,"+"password VARCHAR(100) NOT NULL"+")";
        arg0.execSQL(sql);
        System.out.println("************************正在创建");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        String sql="DROP TABLE IF EXISTS "+TABLENAME1;       //删除
        arg0.execSQL(sql);
        sql="CREATE TABLE "+TABLENAME1+"("+"id INTEGER PRIMARY KEY,"+"word VARCHAR(100) NOT NULL,"+"chinese VARCHAR(100) NOT NULL"+")";
        arg0.execSQL(sql);
        sql="DROP TABLE IF EXISTS "+TABLENAME2;       //删除
        arg0.execSQL(sql);
        sql="CREATE TABLE "+TABLENAME2+"("+"id INTEGER PRIMARY KEY,"+"word VARCHAR(100) NOT NULL,"+"chinese VARCHAR(100) NOT NULL"+")";
        arg0.execSQL(sql);
        sql="DROP TABLE IF EXISTS "+TABLENAME3;       //删除
        arg0.execSQL(sql);
        sql="CREATE TABLE "+TABLENAME3+"("+"id INTEGER PRIMARY KEY,"+"word VARCHAR(100) NOT NULL,"+"chinese VARCHAR(100) NOT NULL"+")";
        arg0.execSQL(sql);
        System.out.println("************************更新");
        this.onCreate(arg0);
    }

}

