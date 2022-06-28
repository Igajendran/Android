package com.example.traveltourism;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class GalleryDisplayAdapter extends FirebaseRecyclerAdapter<GalleryClass, GalleryDisplayAdapter.MyViewHolder> {

    public GalleryDisplayAdapter(FirebaseRecyclerOptions<GalleryClass> options) {
        super(options);
    }

    @NonNull
    @Override
    public GalleryDisplayAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull GalleryClass model) {
        holder.txtView.setText(model.getName());
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.getUrl());
        Glide.with(holder.itemView.getContext()).load(storageReference).into(holder.imgProduct);
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView txtView;
        ImageView imgProduct;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.gallery_layout, parent, false));
            imgProduct = itemView.findViewById(R.id.imgGallery);
            txtView = itemView.findViewById(R.id.txt);
        }
    }
}
