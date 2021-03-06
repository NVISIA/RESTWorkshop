package com.nvisia.restlab.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	private Restaurant restaurant;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
    @Column(name = "RESERVED_BY")
    private String reservationName;
	@Column(name = "PARTY_SIZE")
	private Integer partySize;
	@Column(name = "CANCELLED")
	private Boolean cancelled;
	
	public Reservation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getPartySize() {
		return partySize;
	}

	public void setPartySize(Integer partySize) {
		this.partySize = partySize;
	}

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getReservationName() { return reservationName; }

    public void setReservationName(String reservationName) { this.reservationName = reservationName; }
}