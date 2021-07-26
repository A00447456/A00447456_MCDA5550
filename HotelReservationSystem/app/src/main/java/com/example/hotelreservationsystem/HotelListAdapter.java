package com.example.hotelreservationsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private List<HotelListData> hotelListData;
    private LayoutInflater layoutInflater;
    HotelCallback callback;
    private ItemClickListener clickListener;

    //public int [] images;




     HotelListAdapter(Context context, List<HotelListData> hotelListData){
        this.layoutInflater = LayoutInflater.from(context);
        this.hotelListData = hotelListData;
       // this.callback=callback;

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelListAdapter.ViewHolder holder, int position) {

//        Glide.with(holder.itemView.getContext())
//                .load(hotelListData.get(position).getDrawableResource())
//                .transforms(new CenterCrop(), new RoundedCorners(16))
//                .into(holder.hotelImg);
        String hotelName = hotelListData.get(position).getHotelName();
        String hotelPrice = hotelListData.get(position).getPrice();
        String hotelAvailability = hotelListData.get(position).getAvailability();
        int hotel_id = hotelListData.get(position).getHotel_id();
     //   int image_id = images[position];

        holder.hotelName.setText(hotelName);
        holder.price.setText("$ "+hotelPrice);
        if(hotelAvailability=="true"){
            holder.availability.setText("Available");
        }
        else{
            holder.availability.setText("Not Available");
        }
       // holder.hotelImg.setImageResource(image_id);
    }

    @Override
    public int getItemCount() {
        if (hotelListData!=null){
            return hotelListData.size();
        }

        else
            return 0;
    }

    public void setClickListener(ItemClickListener itemClickListener){
         this.clickListener=itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView  hotelImg, imgContainer;
        TextView hotelName, price, availability, detailsText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            price = itemView.findViewById(R.id.price_textView);
            hotelName = itemView.findViewById(R.id.hotelName_textView);
            availability = itemView.findViewById(R.id.availability_textView);
            hotelImg =itemView.findViewById(R.id.hotel_image);
            imgContainer=itemView.findViewById(R.id.container_image);
            detailsText=itemView.findViewById(R.id.details_textView);


            itemView.setOnClickListener(this);
        //{
//                @Override
//                public void onClick(View v) {
//                    callback.onHotelItemClick(getAdapterPosition(),
//                            imgContainer,
//                            hotelName,
//                            price,
//                            availability
//                            );
//                }
//            });
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onClick(itemView, getAbsoluteAdapterPosition());
            }
        }
    }
}
