package com.nvisia.restlab.services;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import com.nvisia.restlab.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ravt on 5/22/14.
 */
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Restaurant> getRestaurants() {
        return null;
    }

    @Override
    public Restaurant getRestaurant(long id) {
        return null;
    }

    @Override
    public List<Reservation> getReservations(long restaurantId) {
        return null;
    }

    @Override
    public Reservation makeReservation(Reservation reservation) {
        return null;
    }
}
