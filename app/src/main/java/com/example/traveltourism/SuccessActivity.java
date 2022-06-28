package com.example.traveltourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Button btnHome = findViewById(R.id.btnHome);
       // Button buttonHome = findViewById(R.id.buttonHome);
        btnHome.setOnClickListener(view -> {
            goHomeActivity();
        });
//        buttonHome.setOnClickListener(view -> {
//            goHomeActivity();
//        });


    }
    public void goHomeActivity() {
        Intent intent = new Intent(SuccessActivity.this, Home.class);
        startActivity(intent);
    }
}