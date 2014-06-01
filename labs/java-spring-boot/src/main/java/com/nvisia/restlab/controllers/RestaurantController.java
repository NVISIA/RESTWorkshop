package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	@Autowired
	private ReservationRepository reservationRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getRestaurants() {
        Iterable<Restaurant> iter = restaurantRepo.findAll();
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        for (Restaurant restaurant: iter) {
            restaurants.add(restaurant);
        }

        return restaurants;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepo.findOne(id);
        return restaurant;
    }

}