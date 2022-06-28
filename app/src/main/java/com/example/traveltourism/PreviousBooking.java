package com.example.traveltourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.DownloadManager;
import android.content.Intent;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PreviousBooking extends AppCompatActivity {
        private Query query;
        private PreviousBookingAdapter adapter;
        private RecyclerView rView;


        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_previous_booking);
            query= FirebaseDatabase.getInstance().getReference().child("PreviousBookings");
            FirebaseRecyclerOptions<PreviousBookingClass> options=new FirebaseRecyclerOptions.Builder<PreviousBookingClass>()
                    .setQuery(query,PreviousBookingClass.class)
                    .build();

            adapter=new PreviousBookingAdapter(options);
            rView=findViewById(R.id.rViewBookings);
            rView.setAdapter(adapter);
            rView.setLayoutManager(new LinearLayoutManager(this));
        }
        @Override
        protected void onStart() {
            super.onStart();
            adapter.startListening();
        }
    }