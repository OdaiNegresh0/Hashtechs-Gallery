package com.example.hashtechstask.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hashtechstask.FavoriteCallBack;
import com.example.hashtechstask.R;
import com.example.hashtechstask.databinding.ItemImageBinding;
import com.example.hashtechstask.repository.local.DatabaseHelper;
import com.example.model.FavoriteModel;
import com.example.model.ImagesModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {

    private Context context;
    private List<ImagesModel> data;
    private List<FavoriteModel> favoriteList;
    private String imageUrl;
    private String title;
    private String description;
    private FavoriteCallBack callBack;

    public ImagesAdapter(Context context, FavoriteCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
        favoriteList = new ArrayList<>();
    }

    public void setList(List<ImagesModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageBinding binding = ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        imageUrl = data.get(position).getUrls().getRaw();
        title = data.get(position).getUser().getUsername();
        description = data.get(position).getUser().getBio();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.binding.ivImage);
        holder.binding.tvTitle.setText(title);
        holder.binding.tvDesc.setText(description);
        holder.binding.favoriteContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteModel favoriteModel = new FavoriteModel(data.get(position).getUrls().getRaw(),
                                                                data.get(position).getUser().getUsername(),
                                                                data.get(position).getUser().getBio());

                favoriteList.add(favoriteModel);
                callBack.onItemLiked(favoriteList);
                holder.binding.ivFavorite.setBackgroundResource(R.drawable.ic_favorite_red);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemImageBinding binding;

        public MyViewHolder(ItemImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
