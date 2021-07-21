package com.example.hotelreservationsystem;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {

    @GET("/HotelDetails")
    public void getHotelsList(Callback<List<HotelListData>> callback);

    //@POST("")
   // Call<Post> createPost(@Body POST post)
}
