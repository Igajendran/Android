package com.example.traveltourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.app.DatePickerDialog;

import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class DatePickerFragment extends Fragment {

    Calendar c;
    TextView txtCheckIn;
    TextView txtCheckOut;
    Button btnSetDateCheckIn;
    Button btnSetDateCheckOut;
    int year, month, day;
    DatePickerDialog datePickerDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.datepicker_fragment, container, false);
        txtCheckIn  = v.findViewById(R.id.txtCheckIn);
        txtCheckOut = v.findViewById(R.id.txtCheckOut);
        btnSetDateCheckIn = v.findViewById(R.id.btnSetDateCheckIn);
        btnSetDateCheckOut = v.findViewById(R.id.btnSetDateCheckOut);
        Button btnBook = v.findViewById(R.id.btnBooknow);

        String pkgName = getArguments().getString("pkgName");
        String pkgPrice = getArguments().getString("pkgPrice");
        String pkgDetails = getArguments().getString("pkgDetails");
        String pkgImg = getArguments().getString("pkgImg");
        String pkg = getArguments().getString("pkg");

        // perform click event on edit text
        btnSetDateCheckIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // calender class's instance and get current date , month and year from calender
                    c = Calendar.getInstance();
                    int mYear = c.get(Calendar.YEAR); // current year
                    int mMonth = c.get(Calendar.MONTH); // current month
                    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                    // date picker dialog
                    datePickerDialog = new DatePickerDialog(DatePickerFragment.this.getContext(),
                            (view, year, monthOfYear, dayOfMonth) -> {
                                // set day of month , month and year value in the edit text
                                txtCheckIn.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            });
        btnSetDateCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(DatePickerFragment.this.getContext(),
                        (view, year, monthOfYear, dayOfMonth) -> {
                            // set day of month , month and year value in the edit text
                            txtCheckOut.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

            btnBook.setOnClickListener(view -> {
                String dateCheckIn = txtCheckIn.getText().toString();
                String dateCheckOut = txtCheckOut.getText().toString();
                String date = dateCheckIn + " - " + dateCheckOut;
            Intent intent = new Intent(this.getContext(), PaymentActivity.class);
            intent.putExtra("name", pkgName);
            intent.putExtra("price", pkgPrice);
            intent.putExtra("checkin", dateCheckIn);
            intent.putExtra("checkout", dateCheckOut);
                FirebaseDatabase previousBookingNode;
                DatabaseReference bookingReference;

                previousBookingNode = FirebaseDatabase.getInstance();
                bookingReference =previousBookingNode.getReference("PreviousBookings");
                PreviousBookingClass updateData = new PreviousBookingClass(pkg, pkgName, pkgPrice, pkgDetails, date, pkgImg );
                //bookingReference.setValue(updateData);
                bookingReference.child(pkg).setValue(updateData);
            startActivity(intent);
       });

        return v;
    }
}


