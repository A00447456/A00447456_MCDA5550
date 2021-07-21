package com.example.hotelreservationsystem;

import java.io.Serializable;

public class HotelListData implements Serializable {


    String hotel_name, price,availability;



    public HotelListData(String hotel_name, String price, String availability) {
        this.hotel_name = hotel_name;
        this.price = price;
        this.availability = availability;
       // this.imgUrl = imgUrl;
      //  DrawableResource = drawableResource;
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
