package com.example.hashtechstask.repository.local;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.model.FavoriteModel;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "MyFavorite";

    private static final String TABLE_LIST = "MyFavoriteListItem";

    private static final String KEY_ID = "id";
    private static final String KEY_ListItem = "listitem";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LIST_TABLE = "CREATE TABLE " + TABLE_LIST + "(" + KEY_ID
                + " INTEGER," + KEY_ListItem + " TEXT" + ")";

        db.execSQL(CREATE_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIST);
        onCreate(db);
    }


    public void addListItem(List<FavoriteModel> listItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (int i = 0; i < listItem.size(); i++) {

            Log.e("vlaue inserting==", "" + listItem.get(i));
            values.put(KEY_ListItem, new Gson().toJson(listItem.get(i)));
            db.insert(TABLE_LIST, null, values);

        }

        db.close(); // Closing database connection
    }

    public List<FavoriteModel> getListItem() {
        List<FavoriteModel> favoriteModelList = new ArrayList<>();
        Gson gson = new Gson();
        try {
            String selectQuery = "SELECT  * FROM " + TABLE_LIST;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor != null && cursor.moveToFirst()) {

                do {

                    Log.e("value==", "" + cursor.getString(1));
                    favoriteModelList.add(gson.fromJson(cursor.getString(1), FavoriteModel.class));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return favoriteModelList;

        }
    }
}
