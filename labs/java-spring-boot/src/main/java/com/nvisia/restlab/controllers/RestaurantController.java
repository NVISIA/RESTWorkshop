package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;
import com.nvisia.restlab.models.RestaurantResource;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ExposesResourceFor(Restaurant.class)
@RequestMapping("/api/restaurants")
public class RestaurantController extends AbstractRestController {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<RestaurantResource> getRestaurants() {
		
		Iterable<Restaurant> iter = restaurantRepo.findAll();

        List<RestaurantResource> resources = new ArrayList<RestaurantResource>();

		if (iter != null) {
			for(Restaurant restaurant: iter) {
                RestaurantResource resource = new RestaurantResource(restaurant);
                resource.add(linkTo(RestaurantController.class)
                        .slash(restaurant.getId())
                        .withSelfRel());
                resource.add(linkTo(RestaurantController.class)
                        .slash(restaurant.getId())
                        .slash("reservations")
                        .withRel("reservations"));
                resources.add(resource);
			}
		}
		
		return resources;
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant retVal = restaurantRepo.findOne(id);

        if (retVal == null) {
            throw new NotFoundException();
        }

        return new ResponseEntity<Restaurant>(retVal, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {

        restaurantRepo.save(restaurant);

        return restaurant;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
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
		
		if (retVal == null || retVal.size() < 1) {
			throw new NotFoundException();
		}
				
		return retVal;
	}

    @RequestMapping(value = "{id}/reservations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation makeReservation(@PathVariable Long id, @RequestBody Reservation reservation) {

        Restaurant restaurant  = restaurantRepo.findOne(id);
        if (null == restaurant) throw new NotFoundException();

        reservation.setRestaurant(restaurant);
        reservationRepo.save(reservation);
        return reservation;
    }
}