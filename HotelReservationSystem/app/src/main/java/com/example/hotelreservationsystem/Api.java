package com.example.hotelreservationsystem;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient(){

        //changing the URL

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://hotelreservationapi-env.eba-3w3pgnnj.us-east-1.elasticbeanstalk.com/").build();

        ApiInterface api =adapter.create(ApiInterface.class);
        return api;

    }
}
