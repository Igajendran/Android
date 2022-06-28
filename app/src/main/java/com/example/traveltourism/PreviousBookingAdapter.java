package com.example.traveltourism;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class PreviousBookingAdapter extends FirebaseRecyclerAdapter<PreviousBookingClass, PreviousBookingAdapter.MyViewHolder> {


    public PreviousBookingAdapter(FirebaseRecyclerOptions<PreviousBookingClass> options) {
        super(options);
    }

    @NonNull
    @Override
    public PreviousBookingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull PreviousBookingClass model) {
        holder.txtName.setText(model.getPkgName());
        holder.txtPrice.setText(model.getPrice());
        holder.txtDate.setText(model.getDate());
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.getImg());
        Glide.with(holder.itemView.getContext()).load(storageReference).into(holder.imgProduct);
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView txtName;
        TextView txtPrice;
        ImageView imgProduct;
        TextView txtDate;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.previous_booking_layout, parent, false));

            txtName = itemView.findViewById(R.id.txtPkgName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imgProduct = itemView.findViewById(R.id.imgPkg);
            txtDate = itemView.findViewById(R.id.txtDate);
        }
    }
}
