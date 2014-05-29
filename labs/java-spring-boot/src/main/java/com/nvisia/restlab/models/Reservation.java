package com.nvisia.restlab.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Restaurant restaurant;
    @Column(name = "RESERVED_BY")
    private String reservationName;
	@Column(name = "PARTY_SIZE")
	private Integer partySize;
	@Column(name = "CANCELLED")
	private Boolean cancelled;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:00", timezone="CST")
    @Column(name = "RESERVATION_TIME")
    private Timestamp reservationTime;
	
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

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }
}