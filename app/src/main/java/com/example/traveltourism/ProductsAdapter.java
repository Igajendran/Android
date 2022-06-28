package com.example.traveltourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProductsAdapter extends FirebaseRecyclerAdapter<Products,ProductsAdapter.MyViewHolder> {

    public ProductsAdapter(FirebaseRecyclerOptions<Products> options)
    {
        super(options);
    }

    @NonNull
    @Override
    public ProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater,parent);

    }

    @Override
    protected void onBindViewHolder(@NonNull ProductsAdapter.MyViewHolder holder, int position, @NonNull Products model)
    {

        holder.txtname.setText(model.getCountryname());
        holder.txtrate.setText(model.getPrice());
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.getImg());
        Glide.with(holder.itemView.getContext()).load(storageReference).into(holder.img_view);

        holder.txtdetails.setText(model.getDetails());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("pkgName", holder.txtname.getText());
                intent.putExtra("pkgPrice", holder.txtrate.getText());
                intent.putExtra("pkgDetails", holder.txtdetails.getText());
                intent.putExtra("pkgImg", model.getImg());
                intent.putExtra("pkg", model.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtname;
        TextView txtrate;
        ImageView img_view;
        TextView txtdetails;



        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_products_adapter,parent,false));

            txtname=itemView.findViewById(R.id.txtname);
            txtrate=itemView.findViewById(R.id.txtrate);
            img_view=itemView.findViewById(R.id.img_view);
            txtdetails=itemView.findViewById(R.id.txtdetails);


        }



    }




}
