package com.example.hotelreservationsystem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReservationData {




    public int hotel;
    public String checkInDate;
    public String checkOutDate;
    public List<Guest> guests;
    public Integer reservation_id;

    public ReservationData(int hotel, String checkInDate, String checkOutDate, List<Guest> guests) {
        this.hotel = hotel;

        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guests = guests;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

//    public Integer getReservation_id() {
//        return reservation_id;
//    }
//
//    public void setReservation_id(Integer reservation_id) {
//        this.reservation_id = reservation_id;
//    }
}
