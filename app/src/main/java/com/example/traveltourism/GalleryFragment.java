package com.example.traveltourism;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.StorageReference;

public class GalleryFragment extends Fragment {
    private Query query;
    private GalleryDisplayAdapter adapter;
    private RecyclerView rViewGallery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView txtDetails;
        String pkg = getArguments().getString("pkg");

        View v = inflater.inflate(R.layout.gallery_fragment, container, false);

        query = FirebaseDatabase.getInstance().getReference().child("tourism").child(pkg).child("Gallery");;
        FirebaseRecyclerOptions<GalleryClass> options = new FirebaseRecyclerOptions.Builder<GalleryClass>()
                .setQuery(query, GalleryClass.class)
                .build();

        adapter = new GalleryDisplayAdapter(options);
        rViewGallery = v.findViewById(R.id.rViewGallery);
        rViewGallery.setAdapter(adapter);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this.getContext(), 2);
        rViewGallery.setLayoutManager(mLayoutManager);



        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();

    }
}