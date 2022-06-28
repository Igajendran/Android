package com.example.traveltourism;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView txtDetails1;
        TextView txtName1;
        TextView txtPrice1;
        ImageView imgDetails1;

        String pkgName = getArguments().getString("pkgName");
        String pkgPrice = getArguments().getString("pkgPrice");
        String pkgDetails = getArguments().getString("pkgDetails");
        String pkgImg = getArguments().getString("pkgImg");


        View v = inflater.inflate(R.layout.details_fragment, container, false);

        txtName1 = v.findViewById(R.id.txtName1);
        txtPrice1 = v.findViewById(R.id.txtPrice1);
        txtDetails1 = v.findViewById(R.id.txtDetails1);
        imgDetails1 = v.findViewById(R.id.imgDetails);

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(pkgImg);
        Glide.with(this.getContext()).load(storageReference).into(imgDetails1);

        txtName1.setText(pkgName);
        txtPrice1.setText(pkgPrice);
        txtDetails1.setText(pkgDetails);
        return v;
    }
}
