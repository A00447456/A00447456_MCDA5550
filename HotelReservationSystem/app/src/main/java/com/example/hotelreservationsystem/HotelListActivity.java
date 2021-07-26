package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import androidx.core.util.Pair;

public class HotelListActivity extends AppCompatActivity  implements  ItemClickListener{

    String numberOfGuests, startDateString, endDateString, guestName;
    private static final String TAG = "HotelListActivity";
   // ArrayList<HotelListData> list = new ArrayList<>();
    RecyclerView recyclerView;
    List<HotelListData> userListResponseData;
    ProgressBar progressBar;
    private TextView tittleTextView, detailsTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list_layout);

        numberOfGuests=getIntent().getStringExtra("number of guests");
        startDateString=getIntent().getStringExtra("Check in date");
        endDateString=getIntent().getStringExtra("Check out date");
        guestName=getIntent().getStringExtra("guest name");
        progressBar=findViewById(R.id.progressbar);
        tittleTextView=findViewById(R.id.sample);
        detailsTextView=findViewById(R.id.textv2);

        tittleTextView.setText(guestName+", Select your Get Away stay!");
        detailsTextView.setText("for "+ numberOfGuests+" guests and from "+startDateString+" to "+endDateString);

        getHotelsListData();
    }


    public void getHotelsListData(){
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = Api.getClient();
        Call<List<HotelListData>> getHotelLi = apiInterface.getAllData();
        getHotelLi.enqueue(new Callback<List<HotelListData>>() {
            @Override
            public void onResponse(Call<List<HotelListData>> call, Response<List<HotelListData>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                userListResponseData=response.body();
                setUpRecyclerView();
            }

            @Override
            public void onFailure(Call<List<HotelListData>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

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
        int hotel_id = hotelListData.getHotel_id();

        Intent intent = new Intent(HotelListActivity.this,HotelSummaryActivity.class);
        intent.putExtra("hotel name", hotelName);
        intent.putExtra("price", price);
        intent.putExtra("availability", availability);
        intent.putExtra("check in date", startDateString);
        intent.putExtra("check out date", endDateString);
        intent.putExtra("number of guests",numberOfGuests);
        intent.putExtra("guest name", guestName);
        intent.putExtra("hotel id", hotel_id);
        startActivity(intent);

    }

}
