package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.HotelsDetails;

public interface HotelRepo extends JpaRepository<HotelsDetails, Long>{

}
