package com.example.demo.entities;

import javax.persistence.*;

@Entity
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int guest_id;
		
	@Column
	private String name;
	
	@Column
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Reservations.class)
	private Reservations reservation;
	
	public Reservations getReservation() {
		return reservation;
	}

	public void setReservation(Reservations reservation) {
		this.reservation = reservation;
	}
	
	
	public Guest() {
	}
	
	public Guest(int guest_id, String name, int age) {
		super();
		this.guest_id = guest_id;
		this.name = name;
		this.age = age;
	}
	
	public Guest(int guest_id) {
		super();
		this.guest_id = guest_id;
	}
	
	public int getGuest_id() {
		return guest_id;
	}
	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
}
