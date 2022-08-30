package com.example.hashtechstask.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hashtechstask.databinding.ItemFavoriteBinding;
import com.example.hashtechstask.databinding.ItemImageBinding;
import com.example.model.FavoriteModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>{

    private List<FavoriteModel> data;
    private Context context;
    private String imageUrl;
    private String title;
    private String description;

    public FavoriteAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<FavoriteModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavoriteBinding binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);
        return new FavoriteAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        imageUrl = data.get(holder.getAdapterPosition()).getImageUrl();
        title = data.get(holder.getAdapterPosition()).getTitle();
        description = data.get(holder.getAdapterPosition()).getDesc();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.binding.ivImage);
        holder.binding.tvTitle.setText(title);
        holder.binding.tvDesc.setText(description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ItemFavoriteBinding binding;
        public MyViewHolder(ItemFavoriteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
