package com.nvisia.restlab.services;

import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;

import java.util.List;

public interface RestaurantService {
	
	public List<Restaurant> getRestaurants();
	
	public Restaurant getRestaurant(long id);
	
	public List<Reservation> getReservations(long restaurantId);
	
	public Reservation makeReservation(Reservation reservation);

}
