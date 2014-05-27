package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController extends AbstractRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@RequestMapping(method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public List<Reservation> getReservations() {
		List<Reservation> retVal = new ArrayList<Reservation>();
		
		for (Reservation reservation: reservationRepo.findAll()) {
			retVal.add(reservation);
		}
		return retVal;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public Reservation getReservationById(Long id) {
		Reservation reservation = reservationRepo.findOne(id);
		
		if (reservation == null) throw new NotFoundException();
		return reservation;
	}
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	public Reservation makeReservation(@RequestBody Reservation reservation) {
		
		Long restId = reservation.getRestaurant().getId();
		Restaurant restaurant = restaurantRepo.findOne(restId);
		reservation.setRestaurant(restaurant);
		reservation = reservationRepo.save(reservation);
		
		return reservation;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
	public Reservation updateReservation(@RequestBody Reservation reservation) {

		Long restId = reservation.getRestaurant().getId();
		Restaurant restaurant = restaurantRepo.findOne(restId);
		reservation.setRestaurant(restaurant);
		reservation = reservationRepo.save(reservation);
		
		return reservation;
	}
	
}
