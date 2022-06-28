package com.example.traveltourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    String url1 = "@drawable/bannerone.jpg";
    String url2 = "@drawable/bannertwo.jpg";
    String url3 = "@drawable/bannerthree.jpg";

    Button btnSeeCollection;
    Button btnbooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSeeCollection = findViewById(R.id.btn_collection);
        btnbooking=findViewById(R.id.btn);

        btnSeeCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeCollectionButtonClicked();
            }
        });

        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, PreviousBooking.class);
                startActivity(i);
            }
        });


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = findViewById(R.id.slider);


        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    private void seeCollectionButtonClicked() {
        Intent i = new Intent(this, ProductList.class);
        startActivity(i);
    }
}