package com.example.practice_1108;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=6;

    public DBHelper(Context context){
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql="create table tb_gallery ("+
                "_id integer primary key autoincrement," +
                "image not null," +
                "title, " +
                "count)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_gallery (image,title,count) values ('img01','카메라','1080')");
        db.execSQL("insert into tb_gallery (image,title,count) values ('img02','즐겨찾기','218')");
        db.execSQL("insert into tb_gallery (image,title,count) values ('img03','스크린샷','105')");
        db.execSQL("insert into tb_gallery (image,title,count) values ('img04','다운로드','64')");
        db.execSQL("insert into tb_gallery (image,title,count) values ('img05','앨범1','37')");
        db.execSQL("insert into tb_gallery (image,title,count) values ('img06','앨범2','150')");
        db.execSQL("insert into tb_gallery (image,title,count) values ('img07','앨범3','91')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_gallery");
            onCreate(db);
        }
    }
}
