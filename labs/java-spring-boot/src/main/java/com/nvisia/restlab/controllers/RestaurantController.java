package com.nvisia.restlab.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController extends AbstractRestController {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Restaurant> getRestaurants() {
		
		Iterable<Restaurant> iter = restaurantRepo.findAll();
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		if (iter != null) {
			for(Restaurant restaurant: iter) {
				restaurants.add(restaurant);
			}
		}
		
		return restaurants;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Restaurant getRestaurant(@PathVariable Long id) {
		Restaurant retVal = restaurantRepo.findOne(id);
		
		if (retVal == null) {
			throw new NotFoundException();
		}
	 
		return retVal;
	}
	
	@RequestMapping(value = "/{id}/reservations", method = RequestMethod.GET)
	public List<Reservation> getReservationsForRestaurant(@PathVariable Long id) {
		
		Restaurant restaurant = restaurantRepo.findOne(id);
		
		if (restaurant == null) {
			throw new NotFoundException();
		}
		
		List<Reservation> retVal = new ArrayList<Reservation>();
		for (Reservation reservation: restaurant.getReservations()) {
			retVal.add(reservation);
		}
		
		return retVal;
	}
	
}