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

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton btnVisa =  findViewById(R.id.radioButtonVisa);
        RadioButton btnMastercard = findViewById(R.id.radioButtonMastercard);
        RadioButton btnUPI = findViewById(R.id.radioButtonUPI);
        Button btnPay = findViewById(R.id.btnPaynow);

        String pkgName = getIntent().getStringExtra("name");
        String pkgRate = getIntent().getStringExtra("price");
        String checkIn = getIntent().getStringExtra("checkin");
        String checkOut = getIntent().getStringExtra("checkout");
        String date = checkIn + " - " + checkOut;

        TextView displayMsg = findViewById(R.id.txtDisplay);
        TextView displayName = findViewById(R.id.txtPackageName);
        TextView displayPrice = findViewById(R.id.txtPackagePrice);
        TextView displayDate = findViewById(R.id.txtPackageDate);

        displayName.setText(pkgName);
        displayPrice.setText(pkgRate);
        displayDate.setText(date);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragHead = fm.findFragmentById(R.id.framePayment);

        if(fragHead == null) {
            fragHead = new VisaFragment();
            fm.beginTransaction()
                    .add(R.id.framePayment, fragHead)
                    .commit();
        }

        btnPay.setOnClickListener(view -> {
            Intent intent = new Intent(PaymentActivity.this, SuccessActivity.class);
            startActivity(intent);
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btnPay.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragHead = fm.findFragmentById(R.id.framePayment);
                if(btnVisa.isChecked()) {
                        fragHead = new VisaFragment();
                        fm.beginTransaction()
                                .replace(R.id.framePayment, fragHead)
                                .commit();
                } else if(btnMastercard.isChecked()) {
                        fragHead = new VisaFragment();
                        fm.beginTransaction()
                                .replace(R.id.framePayment, fragHead)
                                .commit();
                } else if(btnUPI.isChecked()) {
                        fragHead = new UPIFragment();
                        fm.beginTransaction()
                                .replace(R.id.framePayment, fragHead)
                                .commit();
                }
            }
        });
    }
}