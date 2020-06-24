package com.example.Temporary.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "user_info")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInfoId;

	@OneToOne
	@JoinColumn(name = "total_order_id")
	private TotalOrder totalOrder;

	@Column(name = "user_name")
	@Size(max = 30)
	private String userName;

	@Column(name = "user_phone")
	private String userPhone;

	@Column(name = "user_address")
	private String userAddress;

	@Column(name = "payment_method")
	private String paymentMethod;

	public UserInfo() {
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public TotalOrder getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(TotalOrder totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
