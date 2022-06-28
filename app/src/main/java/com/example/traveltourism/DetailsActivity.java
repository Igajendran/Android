package com.example.traveltourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton btnDetails =  findViewById(R.id.radioButtonDetails);
        RadioButton btnDatepicker = findViewById(R.id.radioButtonDatepicker);
        RadioButton btnGallery = findViewById(R.id.radioButtonGalery);

        String pkgName    = getIntent().getStringExtra("pkgName");
        String pkgPrice   = getIntent().getStringExtra("pkgPrice");
        String pkgDetails = getIntent().getStringExtra("pkgDetails");
        String pkg        = getIntent().getStringExtra("pkg");
        String pkgImg     = getIntent().getStringExtra("pkgImg");



        FragmentManager fm = getSupportFragmentManager();
        Fragment fragHead = fm.findFragmentById(R.id.framePayment);

        Bundle bundle = new Bundle();
        bundle.putString("pkgDetails", pkgDetails);
        bundle.putString("pkgPrice", pkgPrice);
        bundle.putString("pkgName", pkgName);
        bundle.putString("pkg", pkg);
        bundle.putString("pkgImg", pkgImg);

        btnDetails.setChecked(true);
        if(fragHead == null) {
            fragHead = new DetailsFragment();
            fragHead.setArguments(bundle);
            fm.beginTransaction()
                    .add(R.id.framePayment, fragHead)
                    .commit();
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragHead = fm.findFragmentById(R.id.framePayment);
                if(btnDetails.isChecked()) {
                    fragHead = new DetailsFragment();
                    fragHead.setArguments(bundle);
                    fm.beginTransaction()
                            .replace(R.id.framePayment, fragHead)
                            .commit();
                } else if(btnGallery.isChecked()) {
                    fragHead = new GalleryFragment();
                    fragHead.setArguments(bundle);
                    fm.beginTransaction()
                            .replace(R.id.framePayment, fragHead)
                            .commit();
                } else if(btnDatepicker.isChecked()) {
                    fragHead = new DatePickerFragment();
                    fragHead.setArguments(bundle);
                    fm.beginTransaction()
                            .replace(R.id.framePayment, fragHead)
                            .commit();
                }
            }
        });
    }
}