package com.example.demo.entities;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservations {


	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long reservation_id;
		

	@Column
	private String CheckInDate;
	
	@Column
	private String CheckOutDate;
	
	@ManyToOne(optional = false)
	private HotelsDetails hotel;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	private List<Guest> guests = new ArrayList<>();
	
	public Reservations() {
		
	}
	
	public Reservations(long reservation_id) {
		super();
		this.reservation_id = reservation_id;
	}
	
	public Reservations(long reservation_id, String checkInDate, String checkOutDate, HotelsDetails hotel,
			List<Guest> guests) {
		super();
		this.reservation_id = reservation_id;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		this.hotel = hotel;
		this.guests = guests;
	}
	
	public long getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(long reservation_id) {
		this.reservation_id = reservation_id;
	}
	
	public HotelsDetails getHotel() {
		return hotel;
	}
	public void setHotel(HotelsDetails hotel) {
		this.hotel = hotel;
	}
	public String getCheckInDate() {
		return CheckInDate;
	}
	public void setCheckInDate(String checkInDate) {
		CheckInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return CheckOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		CheckOutDate = checkOutDate;
	}
	public List<Guest> getGuests() {
		return guests;
	}
	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}
	public Reservations getResvervation() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	
	
}
