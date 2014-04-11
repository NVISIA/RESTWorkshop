package com.nvisia.restlab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController extends AbstractRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Reservation getReservationById(Long id) {
		Reservation reservation = reservationRepo.findOne(id);
		
		if (reservation == null) throw new NotFoundException();
		return reservation;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Reservation makeReservation(@RequestBody Reservation reservation) {
		
		Long restId = reservation.getRestaurant().getId();
		Restaurant restaurant = restaurantRepo.findOne(restId);
		reservation.setRestaurant(restaurant);
		reservation = reservationRepo.save(reservation);
		
		return reservation;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Reservation updateReservation(@RequestBody Reservation reservation) {

		Long restId = reservation.getRestaurant().getId();
		Restaurant restaurant = restaurantRepo.findOne(restId);
		reservation.setRestaurant(restaurant);
		reservation = reservationRepo.save(reservation);
		
		return reservation;
	}
	
}