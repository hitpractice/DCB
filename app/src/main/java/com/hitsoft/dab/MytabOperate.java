package com.hitsoft.dab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MytabOperate {
    private static final String TABLENAME1="shengcibiao";
    private static final String TABLENAME2="zhuce";
    private SQLiteDatabase db=null;

    public MytabOperate(SQLiteDatabase db){
        this.db=db;
    }

    public void insert(String name ,String message){       //插入商家表
        String sql="INSERT INTO "+TABLENAME1+"(word,chinese) VALUES ('"+name+"','"+message+"')";
        this.db.execSQL(sql);
        this.db.close();
    }

    public void insert2(String user ,String password){       //插入客户表
        String sql="INSERT INTO "+TABLENAME2+"(user,password) VALUES ('"+user+"','"+password+"')";
        this.db.execSQL(sql);
        Cursor cursor=this.db.rawQuery("select * from "+TABLENAME2,null);
        if(cursor.moveToFirst())
        {
            while(true)
            {
                Log.d("username#",cursor.getString(0)+cursor.getString(1));
                if(!cursor.moveToNext())
                    break;
            }
        }

        this.db.close();
    }
    public void delete(int id){
        String sql="DELETE FROM "+TABLENAME1+" WHERE id = "+id;

        this.db.execSQL(sql);
        this.db.close();
    }

}