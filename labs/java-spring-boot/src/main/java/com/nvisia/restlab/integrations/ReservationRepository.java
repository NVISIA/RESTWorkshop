package com.nvisia.restlab.integrations;

import org.springframework.data.repository.CrudRepository;

import com.nvisia.restlab.models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
