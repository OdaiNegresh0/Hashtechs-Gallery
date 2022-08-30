package com.example.hashtechstask.repository.api;

import com.example.model.ImagesModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface APIInterface {

    @GET("photos/")
    Single<List<ImagesModel>> getImages(@Query("client_id") String clientId);
}
