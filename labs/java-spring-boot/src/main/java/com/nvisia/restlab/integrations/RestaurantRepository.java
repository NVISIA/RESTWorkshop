package com.nvisia.restlab.integrations;

import com.nvisia.restlab.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
