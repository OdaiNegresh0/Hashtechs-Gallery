package com.example.hashtechstask.ui.fragment.favorite;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.hashtechstask.base.BaseViewModel;
import com.example.hashtechstask.repository.local.DatabaseHelper;
import com.example.model.FavoriteModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class FavoriteViewModel extends BaseViewModel {

    public MutableLiveData<List<FavoriteModel>> favoriteListResponse = new MutableLiveData<>();
    public MutableLiveData<Boolean> deleteResponse = new MutableLiveData<>();
    private DatabaseHelper db;
    private List<FavoriteModel> favoriteList;
    private Context context;

    public void setContext(Context context){
        this.context = context;
        db = new DatabaseHelper(context);
    }
    public void getFavorite() {
        loading.setValue(true);
        favoriteList = new ArrayList<>();
        favoriteListResponse.setValue(db.getListItem());

    }

    public void deleteFavorite(Context context, String kye) {
        loading.setValue(true);
        deleteResponse.setValue(true);
    }
}
