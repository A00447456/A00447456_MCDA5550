package com.example.hotelreservationsystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class HotelSummaryActivity extends Activity {

    String guestName, checkInDate, checkOutDate, hotelName, availability, price, numberOfGuests, hotelId;
    TextView name_textView, details1_textView, details2_textView, hotelNameTextView, priceTextView, availabilityTextView, dummyTextV;
    List<Guest> guestsList = new ArrayList<Guest>();
    LinearLayout guestLinearLayout;
    Button getAwayButton;
    ReservationData reservationData;
    ReservationId reservationId;
    Animation circleAnim;
    View circleView;
    //Drawable edit_text_shape = getDrawable(R.drawable.edit_text_shape);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_summary_layout);

//        Guest g1 = new Guest("Hem", 22);
//        guests.add(g1);



        guestName = getIntent().getStringExtra("guest name");
        checkInDate = getIntent().getStringExtra("check in date");
        checkOutDate = getIntent().getStringExtra("check out date");
        hotelName = getIntent().getStringExtra("hotel name");
        price = getIntent().getStringExtra("price");
        availability = getIntent().getStringExtra("availability");
        numberOfGuests = getIntent().getStringExtra("number of guests");
        hotelId=getIntent().getStringExtra("hotel id");

       // int hotelIdInt = Integer.parseInt(hotelId);
        int numberOfGuestInt = Integer.parseInt(numberOfGuests);

        name_textView = findViewById(R.id.details1_textView);
        details1_textView = findViewById(R.id.details2_textView);
        details2_textView = findViewById(R.id.details3_textView);
        hotelNameTextView = findViewById(R.id.hotelName_textView);
        priceTextView = findViewById(R.id.price_textView);
        getAwayButton=findViewById(R.id.bookButton);
        dummyTextV=findViewById(R.id.dummyText);
       // availabilityTextView = findViewById(R.id.availability_textView);

        name_textView.setText(" Oh yeah " + guestName + "! ");
        details1_textView.setText("You are almost done. Let's get details of you and " + (numberOfGuestInt - 1) + " others,");
        details2_textView.setText("from " + checkInDate + " to " + checkOutDate);
        hotelNameTextView.setText(hotelName);
        priceTextView.setText("$ "+price);
//        if (availability == "true") {
//            availabilityTextView.setText("Available");
//        }
//        else {
//            availabilityTextView.setText("Not Available");
//        }


        guestLinearLayout = findViewById(R.id.guestLinearLayout);
        for (int i = 0; i < numberOfGuestInt; i++) {
            EditText guestNameInput = new EditText(HotelSummaryActivity.this);
            guestNameInput.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            // guestNameInput.setBackground(edit_text_shape);
            guestNameInput.setHint("Enter the Guest Name");
            guestLinearLayout.addView(guestNameInput);
            EditText guestAgeInput = new EditText(HotelSummaryActivity.this);
            guestAgeInput.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            guestAgeInput.setHint(" Enter the Guest age ");
            guestAgeInput.setInputType(numberOfGuestInt);
            guestLinearLayout.addView(guestAgeInput);
        }

        getAwayButton.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 for (int i = 0; i < 2 * numberOfGuestInt; i += 2) {
                                                     EditText guestNameEditText = (EditText) guestLinearLayout.getChildAt(i);
                                                     String guestNameIP = guestNameEditText.getText().toString();
                                                     EditText guestAgeEditText = (EditText) guestLinearLayout.getChildAt(i + 1);
                                                     String guestAgeIPst = guestAgeEditText.getText().toString();
                                                     int guestAgeIP = Integer.parseInt(guestAgeIPst);
//                    testTextView.append(guestNameIP);
//                    testTextView.append(" "+guestAgeIP+" ");
                                                     Guest guests = new Guest(guestNameIP, guestAgeIP);
                                                     guestsList.add(guests);
                                                 }

                                                 reservationData = new ReservationData(4,checkInDate,checkOutDate,guestsList);
                                                 ApiInterface apiInterface = Api.getClient();
                                                 Call<ReservationId> getPostId = apiInterface.getReservation_id(reservationData);
                                                 getPostId.enqueue(new Callback<ReservationId>() {
                                                     @Override
                                                     public void onResponse(Call<ReservationId> call, Response<ReservationId> response) {
                                                         if (!response.isSuccessful()) {
                                                             Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                                                             return;
                                                         }
                                                         reservationId = response.body();
                                                         //dummyTextV.setText(reservationId.getReservation_id());
                                                         Intent intent = new Intent(HotelSummaryActivity.this, FinalScreen.class);
                                                         intent.putExtra("reservation id",  reservationId.getReservation_id());
                                                         intent.putExtra("guest name", guestName);

                                                         startActivity(intent);
                                                     }

                                                     @Override
                                                     public void onFailure(Call<ReservationId> call, Throwable t) {
                                                         Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                                                     }
                                                 });


                                             }

                                         });
//        String json = "{\"foo\":\"guestName\",\"bar\":\"kat\"}";
//        TypedInput in = null;
//        try {
//            in = new TypedByteArray("application/json", json.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        //
//
//        addGuestList();
//
//    }
//
//    public void addGuestList(){
//        ReservationData reservationData = new ReservationData(1,checkInDate,checkOutDate,guests);
//


//        reservationData.setCheckInDate(checkInDate);
//        reservationData.setCheckOutDate(checkOutDate);
//        reservationData.setHotel(1);
//        reservationData.setGuests([("hem",21)]);

    }

//    public void go(View view) {
//
//    }
}