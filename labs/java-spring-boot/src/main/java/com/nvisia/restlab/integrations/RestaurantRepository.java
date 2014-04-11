package com.nvisia.restlab.integrations;

import org.springframework.data.repository.CrudRepository;

import com.nvisia.restlab.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
