package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	@Autowired
	private ReservationRepository reservationRepo;
}