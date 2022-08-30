package com.example.hashtechstask.ui.activity.main;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.hashtechstask.R;
import com.example.hashtechstask.databinding.ActivityMainBinding;
import com.example.hashtechstask.base.BaseActivity;
import com.example.hashtechstask.ui.fragment.favorite.FavoriteFragment;
import com.example.hashtechstask.ui.fragment.home.HomeFragment;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private int activeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    public void init(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        setContentView(view);
        addFragment(binding.container.getId() , new HomeFragment() , HomeFragment.class.getSimpleName() , "HomeBackStack");
        btnClick();
    }

    private void setActiveButtonStyle() {
            if (activeButton == binding.btnImages.getId()) {
                binding.btnImages.setBackgroundResource(R.drawable.btn_background);
                binding.btnMyFavourite.setBackgroundResource(R.drawable.input_background);
            } else if (activeButton == binding.btnMyFavourite.getId()) {
                binding.btnMyFavourite.setBackgroundResource(R.drawable.btn_background);
                binding.btnImages.setBackgroundResource(R.drawable.input_background);
            }
    }


    private void btnClick() {
        binding.btnImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeButton = binding.btnImages.getId();
                setActiveButtonStyle();
                addFragment(binding.container.getId() , new HomeFragment() , HomeFragment.class.getSimpleName() , "HomeBackStack");
            }
        });

        binding.btnMyFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeButton = binding.btnMyFavourite.getId();
                setActiveButtonStyle();
                addFragment(binding.container.getId() , new FavoriteFragment() , FavoriteFragment.class.getSimpleName() , "FavoriteBackStack");
            }
        });
    }

}