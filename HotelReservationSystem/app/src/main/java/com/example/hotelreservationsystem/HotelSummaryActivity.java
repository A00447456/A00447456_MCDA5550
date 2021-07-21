package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HotelSummaryActivity extends AppCompatActivity {

    String guestName, checkInDate, checkOutDate, hotelName, availability, price, numberOfGuests;
    TextView details_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_summary_layout);

        guestName=getIntent().getStringExtra("guest name");
        checkInDate=getIntent().getStringExtra("check in date");
        checkOutDate=getIntent().getStringExtra("check out date");
        hotelName=getIntent().getStringExtra("hotel name");
        price=getIntent().getStringExtra("price");
        availability=getIntent().getStringExtra("availability");
        numberOfGuests=getIntent().getStringExtra("number of guests");

        details_textView=findViewById(R.id.details1_textView);

        details_textView.setText(guestName+ numberOfGuests+checkInDate +checkOutDate+ hotelName+ availability+price);





    }
}