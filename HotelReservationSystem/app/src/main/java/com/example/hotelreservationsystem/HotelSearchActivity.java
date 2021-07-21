package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class HotelSearchActivity extends AppCompatActivity {

    private Button checkInOutButton, searchButton;
    private TextView selectedDate, checkInOutTextView;
    public String datesInput, checkInOutOutput, startDateString, endDateString;
    private TextInputEditText numberOfGuestsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_search_layout);

        //getting intent data from previous activity
        checkInOutOutput=getIntent().getStringExtra("guest name");

        checkInOutButton=findViewById(R.id.checkInAndOut_button);
        selectedDate=findViewById(R.id.selectedDate_textView);
        checkInOutTextView=findViewById(R.id.checkInAndOut_textview);
        searchButton=findViewById(R.id.search_button);
        numberOfGuestsInput=(TextInputEditText)findViewById(R.id.numberOfGuests_textInput);

        //setting dynamic text before the check in and out date
        checkInOutTextView.setText(checkInOutOutput+"! Let us know about your dates of stay");

        //calendar constraints
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("ADT"));
        calendar.clear();
        Long today=MaterialDatePicker.todayInUtcMilliseconds();
        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setValidator(DateValidatorPointForward.now());

        //DatePicker
        MaterialDatePicker.Builder<Pair<Long, Long>> builder= MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select your Check in and out dates");
        builder.setCalendarConstraints(constraintBuilder.build());
        MaterialDatePicker materialDatePicker= builder.build();

        checkInOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
            @Override
            public void onPositiveButtonClick(Pair<Long,Long> selection) {
                SimpleDateFormat simpleFormat = new SimpleDateFormat("dd MMM yyyy");
                Long startDate = selection.first;
                Long endDate = selection.second;
                startDateString = simpleFormat.format(startDate);
                endDateString = simpleFormat.format(endDate);
                selectedDate.setText("Selected Dates: "+startDateString+"-"+endDateString );

                datesInput=materialDatePicker.getHeaderText();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberOfGuests = numberOfGuestsInput.getText().toString();
                Intent intent = new Intent(HotelSearchActivity.this, HotelListActivity.class);
                intent.putExtra("number of guests", numberOfGuests);
                intent.putExtra("Check in date", startDateString);
                intent.putExtra("Check out date", endDateString);
                intent.putExtra("guest name", checkInOutOutput);
                startActivity(intent);
            }
        });
    }
}