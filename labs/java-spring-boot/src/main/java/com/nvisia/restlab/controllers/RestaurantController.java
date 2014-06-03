package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	
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
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant retVal = restaurantRepo.findOne(id);

        return new ResponseEntity<Restaurant>(retVal, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {

        restaurantRepo.save(restaurant);

        return restaurant;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Transactional
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepo.save(restaurant);
        return restaurant;
    }

	@RequestMapping(value = "/{id}/reservations", method = RequestMethod.GET)
	public List<Reservation> getReservationsForRestaurant(@PathVariable Long id, 
		@RequestParam(value = "partySize", required = false) Integer partySize) {
		
		List<Reservation> retVal = null;
		
		if (partySize != null) {
			retVal = reservationRepo.findByRestaurantIdAndPartySize(id,  partySize);
		} else {
			retVal = reservationRepo.findByRestaurantId(id);
		}

		return retVal;
	}

    @RequestMapping(value = "{id}/reservations", method = RequestMethod.POST)
    @Transactional
    public Reservation makeReservation(@PathVariable Long id, @RequestBody Reservation reservation) {

        Restaurant restaurant  = restaurantRepo.findOne(id);

        reservation.setRestaurant(restaurant);
        reservationRepo.save(reservation);
        return reservation;
    }
}