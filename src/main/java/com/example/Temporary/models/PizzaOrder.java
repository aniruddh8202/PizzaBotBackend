package com.example.Temporary.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@Entity
@Table(name = "pizza_order")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PizzaOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_order_id")
    private Long pizzaOrderId;

	@OneToOne
	@JoinColumn(name = "real_pizza_id")
	private RealPizza realPizza;

	@ManyToMany
	@JoinColumn(name = "toppings_id")
	private List<Toppings> toppings;

	@ManyToOne
	@JoinColumn(name = "size_id")
	private Sizes sizes;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pizza_order_id")
//    private List<Toppings> toppings;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pizza_order_id")
//    private Sizes size;

	@Column(name = "pizza_quantity")
	private Long quantity;

	@Column(name = "calc_price")
	private Double pizzaCalculatedPrice;

	public PizzaOrder() {
	}

	public Long getPizzaOrderId() {
		return pizzaOrderId;
	}

	public void setPizzaOrderId(Long pizzaOrderId) {
		this.pizzaOrderId = pizzaOrderId;
	}

	public RealPizza getRealPizza() {
		return realPizza;
	}

	public void setRealPizza(RealPizza realPizza) {
		this.realPizza = realPizza;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPizzaCalculatedPrice() {
		return pizzaCalculatedPrice;
	}

	public void setPizzaCalculatedPrice(Double pizzaCalculatedPrice) {
		this.pizzaCalculatedPrice = pizzaCalculatedPrice;
	}

	public List<Toppings> getToppings() {
		return toppings;
	}

	public void setToppings(List<Toppings> toppings) {
		this.toppings = toppings;
	}

	public Sizes getSizes() {
		return sizes;
	}

	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}
}
