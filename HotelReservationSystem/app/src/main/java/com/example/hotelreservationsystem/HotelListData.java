package com.example.hotelreservationsystem;

import java.io.Serializable;

public class HotelListData implements Serializable {




    String hotel_name, price,availability;
    int hotel_id;

    public HotelListData(String hotel_name, String price, String availability, int hotel_id) {
        this.hotel_name = hotel_name;
        this.price = price;
        this.availability = availability;
        this.hotel_id = hotel_id;
    }

    public HotelListData() {
    }

    public String getHotelName() {
        return hotel_name;
    }

    public void setHotelName(String hotelName) {
        this.hotel_name = hotel_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

   // public String getImgUrl() {
   //     return imgUrl;
  //  }

  //  public void setImgUrl(String imgUrl) {
  //      this.imgUrl = imgUrl;
 //   }

//    public int getDrawableResource() {
//        return DrawableResource;
//    }
//
//    public void setGetDrawableResource(int DrawableResource) {
//        this.DrawableResource = DrawableResource;
//    }
    //public HotelListData(int DrawableResource) {
//        this.DrawableResource = DrawableResource;
//    }

}
