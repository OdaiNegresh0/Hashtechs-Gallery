package com.example.hashtechstask.base;

import com.example.hashtechstask.repository.api.APIService;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<Throwable> error = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    public final CompositeDisposable disposable = new CompositeDisposable();
    public final APIService apiService = APIService.getInstance();

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
