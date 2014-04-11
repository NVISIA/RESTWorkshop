package com.nvisia.restlab.integrations;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nvisia.restlab.models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	
	public List<Reservation> findByRestaurantId(Long id);
	
	public List<Reservation> findByRestaurantIdAndPartySize(Long id, Integer partySize);
}
