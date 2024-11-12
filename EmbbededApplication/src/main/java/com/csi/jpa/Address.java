package com.csi.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String addressState;

	private String addressCity;

	private double addressPinCode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressState, String addressCity, double addressPinCode) {
		super();
		this.addressState = addressState;
		this.addressCity = addressCity;
		this.addressPinCode = addressPinCode;
	}

	@Override
	public String toString() {
		return "Address [addressState=" + addressState + ", addressCity=" + addressCity + ", addressPinCode="
				+ addressPinCode + "]";
	}

}
