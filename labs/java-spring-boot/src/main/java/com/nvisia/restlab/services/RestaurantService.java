package com.nvisia.restlab.services;

import java.util.List;

import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> getRestaurants();
	
	public Restaurant getRestaurant(long id);
	
	public List<Reservation> getReservations(long restaurantId);
	
	public Reservation makeReservation(Reservation reservation);

}
