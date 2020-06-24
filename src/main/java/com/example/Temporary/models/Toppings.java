package com.example.Temporary.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "Toppings")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Toppings {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toppings_id")
    private Long toppingsId;

	@Column(name = "toppings_name")
	private String toppingsName;

	@Column(name = "toppings_price")
	private Double toppingsPrice;

	public Toppings() {
	}

	public Long getToppingsId() {
		return toppingsId;
	}

	public void setToppingsId(Long toppingsId) {
		this.toppingsId = toppingsId;
	}

	public String getToppingsName() {
		return toppingsName;
	}

	public void setToppingsName(String toppingsName) {
		this.toppingsName = toppingsName;
	}

	public Double getToppingsPrice() {
		return toppingsPrice;
	}

	public void setToppingsPrice(Double toppingsPrice) {
		this.toppingsPrice = toppingsPrice;
	}
}
