package com.example.hashtechstask.repository.api;

import android.provider.SyncStateContract;

import com.example.hashtechstask.constant.Constants;
import com.example.model.ImagesModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private static APIService instance;


    private final APIInterface api = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(APIInterface.class);

    private APIService() {
    }

    public static APIService getInstance() {

        if (instance == null) {
            instance = new APIService();
        }
        return instance;
    }

    public Single<List<ImagesModel>> getImages(String clientId) {

        return api.getImages(clientId);
    }
}
