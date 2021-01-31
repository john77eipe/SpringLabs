package com.springlabs.pizzastore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "fullname")
	private String name;

	@Column
	private String company;

	@Column(name = "address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	private String addressLine2;

	@Column(name = "address_line_3")
	private String addressLine3;

	@Column
	private String city;

	@Column
	private String state;

	@Column(name = "postal_code")
	private String pinCode;

	@Column
	private String country;

	@Column
	private Long type;

	@Column(name = "default_billing")
	private Long defaultBilling;

	@Column(name = "default_shipping")
	private Long defaultShipping;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getDefaultBilling() {
		return defaultBilling;
	}

	public void setDefaultBilling(Long defaultBilling) {
		this.defaultBilling = defaultBilling;
	}

	public Long getDefaultShipping() {
		return defaultShipping;
	}

	public void setDefaultShipping(Long defaultShipping) {
		this.defaultShipping = defaultShipping;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", company=");
		builder.append(company);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", addressLine3=");
		builder.append(addressLine3);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pinCode=");
		builder.append(pinCode);
		builder.append(", country=");
		builder.append(country);
		builder.append(", type=");
		builder.append(type);
		builder.append(", defaultBilling=");
		builder.append(defaultBilling);
		builder.append(", defaultShipping=");
		builder.append(defaultShipping);
		builder.append("]");
		return builder.toString();
	}

}