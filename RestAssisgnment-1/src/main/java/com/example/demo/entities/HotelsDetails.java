	package com.example.demo.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.persistence.Id;

@Entity
public class HotelsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long hotel_id;
	
	public HotelsDetails() {
	}
	
	public HotelsDetails(long hotel_id) {
		super();
		this.hotel_id = hotel_id;
	}
	@Column
	private String hotel_name;
	@Column
	private int price;
	@Column
	private boolean availability;
	@JsonIgnore
	@OneToMany(mappedBy = "hotel")
	private List<Reservations> reservations;
	
	public long getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(long hotel_id) {
		this.hotel_id = hotel_id;
	}
	public List<Reservations> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Object setReservation(Reservations reservation) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
