package com.nvisia.restlab.models;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant implements Identifiable<Long> {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@OneToMany(mappedBy = "restaurant")
	private List<Reservation> reservations;

    public Long getId() { return id; }

	public String getName() {
		return name;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}	
}