package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScreen extends AppCompatActivity {

    String guestName, reservationId;
    TextView nameText, idText;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_screen_layout);

        guestName = getIntent().getStringExtra("guest name");
        reservationId = getIntent().getStringExtra("reservation id");

        nameText=findViewById(R.id.nameView);
        idText=findViewById(R.id.idView);
        homeButton=findViewById(R.id.homeButton);

        nameText.setText("Hurray! "+ guestName);
        idText.setText("Your Get Away ID is: "+reservationId);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalScreen.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });




    }
}