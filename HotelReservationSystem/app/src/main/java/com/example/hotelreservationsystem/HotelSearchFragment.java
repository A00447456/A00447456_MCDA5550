package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.TimeZone;

public class HotelSearchFragment extends AppCompatActivity {

    private Button checkInOutButton;
    private TextView selectedDate;
    public String datesInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_search_layout);

        checkInOutButton=findViewById(R.id.checkInAndOut_button);
        selectedDate=findViewById(R.id.selectedDate_textView);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("ADT"));
        calendar.clear();
        Long today=MaterialDatePicker.todayInUtcMilliseconds();

        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setValidator(DateValidatorPointForward.now());

        //DatePicker
        MaterialDatePicker.Builder builder= MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select your Check in and out dates");
      //  builder.setSelection(today);
        builder.setCalendarConstraints(constraintBuilder.build());
        MaterialDatePicker materialDatePicker= builder.build();

        checkInOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                selectedDate.setText("Selected Dates: " + materialDatePicker.getHeaderText());
                datesInput=materialDatePicker.getHeaderText();
            }
        });
    }
}