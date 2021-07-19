package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class WelcomeActivity extends AppCompatActivity {


    TextInputEditText nameEditText;
    Button letsGoButton;
    String guestName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_fragment_layout);


        nameEditText=(TextInputEditText)findViewById(R.id.getNameTextInput);
        letsGoButton=findViewById(R.id.letsGo_button);

        letsGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guestName=nameEditText.getText().toString();
                //Bundle bundle = new Bundle();
                //bundle.putString("guest name", guestName);
                //HotelSearchActivity hotelSearchActivity = new HotelSearchActivity();
                //hotelSearchActivity.setArguments(bundle)
                Intent intent = new Intent(WelcomeActivity.this, HotelSearchActivity.class);
                intent.putExtra("guest name", guestName);
                startActivity(intent);
            }
        });





    }
}