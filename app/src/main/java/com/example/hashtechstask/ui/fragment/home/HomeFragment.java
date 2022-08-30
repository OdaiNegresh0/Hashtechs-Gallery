package com.example.hashtechstask.ui.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hashtechstask.FavoriteCallBack;
import com.example.hashtechstask.R;
import com.example.hashtechstask.base.BaseFragment;
import com.example.hashtechstask.constant.Constants;
import com.example.hashtechstask.databinding.FragmentHomeBinding;
import com.example.hashtechstask.ui.activity.main.MainActivity;
import com.example.hashtechstask.ui.activity.main.MainActivityViewModel;
import com.example.hashtechstask.ui.adapters.ImagesAdapter;
import com.example.model.FavoriteModel;

import java.util.List;

public class HomeFragment extends BaseFragment implements FavoriteCallBack {
    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private ImagesAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater , container , false);
        init();
        return binding.getRoot();
    }

    private void init() {
        viewModel =  new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.setContext(getContext());
        viewModel.getImages(Constants.CLIENT_ID);
        adapter = new ImagesAdapter(getContext() , this);
        observerViewModel();
    }

    @Override
    public void onItemLiked(List<FavoriteModel> favoriteList) {
        viewModel.saveFavorite(favoriteList);
    }


    private void observerViewModel() {

        viewModel.error.observe(getViewLifecycleOwner() , e -> {
            showExceptionError(e);
        });

        viewModel.loading.observe(getViewLifecycleOwner() , isLoading ->{
            if (isLoading != null){
                if (isLoading){
                    showLoading(getContext());
                }else {
                    hideProgress();
                }
            }
        });
        viewModel.imagesResponseModel.observe(getViewLifecycleOwner() , imagesModelResponse -> {
            if (imagesModelResponse != null){
                adapter.setList(imagesModelResponse);
                binding.rvImages.setAdapter(adapter);
                binding.rvImages.setLayoutManager(new LinearLayoutManager(getContext()));
                hideProgress();
            }
        });

        viewModel.saveFavoriteResponse.observe(getViewLifecycleOwner() , favoriteResponse -> {
            if (favoriteResponse != null){
                Toast.makeText(getContext(), "Image added to favorite", Toast.LENGTH_SHORT).show();
                hideProgress();
            }
        });

    }
}