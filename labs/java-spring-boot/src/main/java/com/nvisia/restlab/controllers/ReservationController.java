package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@RequestMapping(method= RequestMethod.GET) 
	public List<Reservation> getReservations() {
		List<Reservation> retVal = new ArrayList<Reservation>();
		
		for (Reservation reservation: reservationRepo.findAll()) {
			retVal.add(reservation);
		}
		return retVal;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Reservation getReservationById(Long id) {
		Reservation reservation = reservationRepo.findOne(id);

		return reservation;
	}
	
}
