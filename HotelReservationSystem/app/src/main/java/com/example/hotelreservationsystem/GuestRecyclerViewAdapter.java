package com.example.hotelreservationsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class GuestRecyclerViewAdapter extends RecyclerView.Adapter<GuestRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    public static ArrayList<GuestRecyclerViewModel> guestRecyclerViewModelArrayList;

    public GuestRecyclerViewAdapter(Context ctx, ArrayList<GuestRecyclerViewModel> guestRecyclerViewModelArrayList){

        this.layoutInflater = LayoutInflater.from(ctx);
        this.guestRecyclerViewModelArrayList = guestRecyclerViewModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_details_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GuestRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextInputEditText guestName, guestAge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            guestName = (TextInputEditText)itemView.findViewById(R.id.guestName_input_textfield);
            guestAge = (TextInputEditText)itemView.findViewById(R.id.guestAge_input_textfield);
        }
    }
}
