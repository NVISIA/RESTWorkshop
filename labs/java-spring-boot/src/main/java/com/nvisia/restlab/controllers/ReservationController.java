package com.nvisia.restlab.controllers;

import com.nvisia.restlab.integrations.ReservationRepository;
import com.nvisia.restlab.integrations.RestaurantRepository;
import com.nvisia.restlab.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> getReservations() {
        Iterable<Reservation> iter = reservationRepo.findAll();
        List<Reservation> reservations = new ArrayList<Reservation>();

        for (Reservation reservation: iter) {
            reservations.add(reservation);
        }

        return reservations;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationRepo.findOne(id);
    }
}
