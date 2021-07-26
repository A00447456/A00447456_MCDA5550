package com.example.hotelreservationsystem;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

//    private static Retrofit retrofit;
//    private static String BASE_URL="http://hotelreservationapihem-env.eba-p5tp3tdc.us-east-1.elasticbeanstalk.com/";

    public static ApiInterface getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hotelreservationapihem-env.eba-p5tp3tdc.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api = retrofit.create(ApiInterface.class);

        return api;
    }

//    public static ApiInterface getClient(){

        //changing the URL



//        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://hotelreservationapi-env.eba-3w3pgnnj.us-east-1.elasticbeanstalk.com/").build();
//
//        ApiInterface api =adapter.create(ApiInterface.class);
//        return api;

    }

