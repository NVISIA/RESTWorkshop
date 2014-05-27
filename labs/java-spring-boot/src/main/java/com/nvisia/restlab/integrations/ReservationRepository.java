package com.nvisia.restlab.integrations;

import com.nvisia.restlab.models.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	
	public List<Reservation> findByRestaurantId(Long id);
	
	public List<Reservation> findByRestaurantIdAndPartySize(Long id, Integer partySize);
}
