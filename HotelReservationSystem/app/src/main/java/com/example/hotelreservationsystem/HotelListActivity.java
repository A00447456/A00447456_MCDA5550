package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import androidx.core.util.Pair;

public class HotelListActivity extends AppCompatActivity  implements  ItemClickListener{

    String numberOfGuests, startDateString, endDateString, guestName;
   // ArrayList<HotelListData> list = new ArrayList<>();
    RecyclerView recyclerView;
    List<HotelListData> userListResponseData;
    ProgressBar progressBar;
    ImageView hotelImg;

   // private int [] images = {R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,R.drawable.h5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list_layout);

        numberOfGuests=getIntent().getStringExtra("number of guests");
        startDateString=getIntent().getStringExtra("Check in date");
        endDateString=getIntent().getStringExtra("Check out date");
        guestName=getIntent().getStringExtra("guest name");
        progressBar=findViewById(R.id.progressbar);






//        hotelImg = findViewById(R.id.hotel_image);
//
//        hotelImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.h1));


//        ArrayList<HotelListData> hotelListData= initHotelListData();
//        recyclerView = findViewById(R.id.hotelList_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(this, hotelListData);
//        recyclerView.setAdapter(hotelListAdapter);


        getHotelsListData();

        
    }



//    public ArrayList<HotelListData> initHotelListData(){
//
//        //HotelListData i = new HotelListData(j.hotelname)
//
//        list.add(new HotelListData("Home wood suites","$1200","available",R.drawable.h1));
//        list.add(new HotelListData(R.drawable.h2));
//        list.add(new HotelListData(R.drawable.h3));
//        list.add(new HotelListData(R.drawable.h4));
//
//
//        list.add(new HotelListData("hodf","dfsdf","fsfsd",1));
//
//
//
//        return list;
//    }


//    private void getHotelsListsData() {
//        progressBar.setVisibility(View.VISIBLE);
    public void getHotelsListData(){
        progressBar.setVisibility(View.VISIBLE);
        Api.getClient().getHotelsList(new Callback<List<HotelListData>>() {
            @Override
            public void success(List<HotelListData> userListResponses, Response response) {
                // in this method we will get the response from API
                userListResponseData = userListResponses;


                // Set up the RecyclerView
                setUpRecyclerView();


            }

            @Override
            public void failure(RetrofitError error) {
                // if error occurs in network transaction then we can get the error in this method.
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

            }
        });





            //Bind the click listener
            //hotelListAdapter.setOnClickListener(this);
        }
    public void setUpRecyclerView(){
        progressBar.setVisibility(View.GONE);
        RecyclerView recyclerView = findViewById(R.id.hotelList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        HotelListAdapter hotelListAdapter = new HotelListAdapter(getApplicationContext(), userListResponseData);
        recyclerView.setAdapter(hotelListAdapter);

        hotelListAdapter.setClickListener(this);




    }

    @Override
    public void onClick(View view, int position) {
        HotelListData hotelListData = userListResponseData.get(position);

        String hotelName = hotelListData.getHotelName();
        String price = hotelListData.getPrice();
        String availability = hotelListData.getAvailability();

        Intent intent = new Intent(HotelListActivity.this,HotelSummaryActivity.class);
        intent.putExtra("hotel name", hotelName);
        intent.putExtra("price", price);
        intent.putExtra("availability", availability);
        intent.putExtra("check in date", startDateString);
        intent.putExtra("check out date", endDateString);
        intent.putExtra("number of guests",numberOfGuests);
        intent.putExtra("guest name", guestName);
        startActivity(intent);

    }

//    @Override
//    public void onHotelItemClick(int pos,
//                                 ImageView imgContainer,
//                                 TextView hotelName,
//                                 TextView price,
//                                 TextView availability) {
//
//        Intent intent = new Intent(this,HotelSummaryActivity.class);
//        intent.putExtra("hotel object", userListResponseData.get(pos));



       // startActivity(intent, optionsCompat.toBundle());

   // }
}
