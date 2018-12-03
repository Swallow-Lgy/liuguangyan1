package com.bawei.liuguangyan1203;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SearchDao {
    private SQLiteDatabase database;
    public SearchDao(Context context){
        SqlHelper helper = new SqlHelper(context);
        database = helper.getReadableDatabase();
    }
    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        database.insert("searchs",null,values);
    }
    public void del(){
        database.delete("searchs",null,null);
    }
}
