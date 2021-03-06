package com.springlabs.pizzastore.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

import java.util.StringJoiner;

@Entity
@Table(name="tbl_authorities")
public class Authorities implements GrantedAuthority {

	private static final long serialVersionUID = -8123526131047887755L;

	private Long id;
	private String authority;
	private UserAccount userAccount;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@ManyToOne
	@JsonBackReference
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Authorities.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("authority='" + authority + "'")
				.toString();
	}
}