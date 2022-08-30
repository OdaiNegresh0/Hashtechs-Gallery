package com.example.hashtechstask.ui.fragment.favorite;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hashtechstask.base.BaseFragment;
import com.example.hashtechstask.databinding.FragmentFavoritBinding;
import com.example.hashtechstask.repository.local.DatabaseHelper;
import com.example.hashtechstask.ui.adapters.FavoriteAdapter;

public class FavoriteFragment extends BaseFragment {
    private FragmentFavoritBinding binding;
    private FavoriteAdapter adapter;
    private FavoriteViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoritBinding.inflate(inflater , container , false);
        init();
        return binding.getRoot();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        viewModel.setContext(getContext());
        adapter = new FavoriteAdapter(getContext());
        viewModel.getFavorite();
        observerViewModel();
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

        viewModel.favoriteListResponse.observe(getViewLifecycleOwner() , favoriteList ->{
            if (favoriteList != null){
                adapter.setList(favoriteList);
                binding.rvImages.setAdapter(adapter);
                binding.rvImages.setLayoutManager(new GridLayoutManager(getContext() , 2));
                hideProgress();
            }
        });

        viewModel.deleteResponse.observe(getViewLifecycleOwner() , deleteResponse -> {
            if (deleteResponse != null){
                Toast.makeText(getContext(), "Image removed from favorite", Toast.LENGTH_SHORT).show();
                hideProgress();
            }
        });
    }
}