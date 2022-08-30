package com.example.hashtechstask.ui.fragment.home;

import android.content.Context;

import com.example.hashtechstask.base.BaseViewModel;
import com.example.hashtechstask.repository.local.DatabaseHelper;
import com.example.model.FavoriteModel;
import com.example.model.ImagesModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel {

    public MutableLiveData<List<ImagesModel>> imagesResponseModel = new MutableLiveData<>();
    public MutableLiveData<Boolean> saveFavoriteResponse = new MutableLiveData<>();
    private DatabaseHelper db;
    private Context context;

    public void setContext(Context context){
        this.context = context;
        db = new DatabaseHelper(context);
    }
    public void saveFavorite(List<FavoriteModel> favoriteList){
        loading.setValue(true);
        db.addListItem(favoriteList);
        saveFavoriteResponse.setValue(true);
    }



    public void getImages(String clientId){
        loading.setValue(true);
        disposable.add(apiService.getImages(clientId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<ImagesModel>>(){
                    @Override
                    public void onSuccess(@NonNull List<ImagesModel> model) {
                        imagesResponseModel.setValue(model);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        error.setValue(e);
                        loading.setValue(false);
                        e.printStackTrace();
                    }
                }));
    }
}
