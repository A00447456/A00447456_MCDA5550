package com.example.hotelreservationsystem;

import android.widget.ImageView;
import android.widget.TextView;

public interface HotelCallback {

    void onHotelItemClick(int pos,
                          ImageView imgContainer,
                          TextView hotelName,
                          TextView price,
                          TextView availability
                          );
}
