package com.example.hotelreservationsystem;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("HotelDetails")
    Call<List<HotelListData>> getAllData();

    @POST("reservation")
    Call<ReservationId> getReservation_id(@Body ReservationData reservationData);


//    @GET("/HotelDetails")
//    public void getHotelsList(Callback<List<HotelListData>> callback);
//
//    @POST("")
//    public void addGuestList(@Body ReservationData reservationData);
//    //Call<ResponseCallback> createPost(@Body ReservationData reservationData);
}
