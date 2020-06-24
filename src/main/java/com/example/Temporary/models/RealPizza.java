package com.example.Temporary.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "real_pizza")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RealPizza {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "real_pizza_id")
    private Long realPizzaId;

	@Column(name = "real_pizza_name")
	private String realPizzaName;

	@Column(name = "real_base_price")
	private Double basePizzaPrice;

//    @ManyToOne
//    @JoinColumn(name = "menu_id", nullable = true)
//    private Menu menu;

	public RealPizza() {
	}

	public Long getRealPizzaId() {
		return realPizzaId;
	}

	public void setRealPizzaId(Long realPizzaId) {
		this.realPizzaId = realPizzaId;
	}

	public String getRealPizzaName() {
		return realPizzaName;
	}

	public void setRealPizzaName(String realPizzaName) {
		this.realPizzaName = realPizzaName;
	}

	public Double getBasePizzaPrice() {
		return basePizzaPrice;
	}

	public void setBasePizzaPrice(Double basePizzaPrice) {
		this.basePizzaPrice = basePizzaPrice;
	}
}
