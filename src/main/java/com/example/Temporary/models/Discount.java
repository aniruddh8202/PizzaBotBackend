package com.example.Temporary.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "discount")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(initialValue = 7000, allocationSize = 1, name = "discountId")
	@Column(name = "discount_id")
	private Long discountId;

	@Column(name = "discount_name")
	private String discountName;

	@Column(name = "discount_percentage")
	private Double discountCalculationPercentage;

	public Discount() {
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Double getDiscountCalculationPercentage() {
		return discountCalculationPercentage;
	}

	public void setDiscountCalculationPercentage(Double discountCalculationPercentage) {
		this.discountCalculationPercentage = discountCalculationPercentage;
	}
}
