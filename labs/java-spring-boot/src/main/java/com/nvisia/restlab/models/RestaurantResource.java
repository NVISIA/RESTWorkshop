package com.nvisia.restlab.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by ravt on 5/2/14.
 */
public class RestaurantResource extends ResourceSupport {

    private Restaurant restaurant;

    public RestaurantResource(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @JsonProperty("id")
    public Long getOid() {
        return this.restaurant.getId();
    }

    public String getName() {
        return this.restaurant.getName();
    }

}


