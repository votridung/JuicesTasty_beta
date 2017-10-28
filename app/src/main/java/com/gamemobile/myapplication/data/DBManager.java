package com.gamemobile.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gamemobile.myapplication.model.Addmore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hands on 28/10/2017.
 */

public class DBManager extends SQLiteOpenHelper {

    private final String TAG = "DBManager";
    private static final String DATABASE_NAME = "students_manager";
    private static final String TABLE_NAME = "students";
    private static final String ID = "id";
    private static final String TEN = "ten";
    private static final String NGUYENLIEU = "nguyenlieu";
    private static final String CACHLAM = "cachlam";
    private static int VERSION = 1;
    private Context context;

    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            TEN + " TEXT, " +
            NGUYENLIEU + " TEXT, " +
            CACHLAM + " TEXT)";

    public DBManager(Context context){
        super(context, DATABASE_NAME, null, VERSION);
        this.context= context;
        Log.d(TAG, "DBManager: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG,"DBManager: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"onUpgrade: ");
    }
    public void addList(Addmore addmore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TEN, addmore.getmTen());
        values.put(NGUYENLIEU, addmore.getmNguyenlieu());
        values.put(CACHLAM, addmore.getmCachlam());

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addList Successfuly");
    }

    public List<Addmore> getAllAdd() {
        List<Addmore> listAddmore = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Addmore addmore = new Addmore();
                addmore.setmID(cursor.getInt(0));
                addmore.setmTen(cursor.getString(1)+"");
                addmore.setmNguyenlieu(cursor.getString(2));
                addmore.setmCachlam(cursor.getString(3));
                listAddmore.add(addmore);

            } while (cursor.moveToNext());
        }
        db.close();
        return listAddmore;
    }
    public int updateAdd(Addmore addmore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TEN, addmore.getmTen());
        contentValues.put(NGUYENLIEU, addmore.getmNguyenlieu());
        contentValues.put(CACHLAM, addmore.getmCachlam());

        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(addmore.getmID())});
    }
    public int deleteADD(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[] {String.valueOf(id)});
    }
}
