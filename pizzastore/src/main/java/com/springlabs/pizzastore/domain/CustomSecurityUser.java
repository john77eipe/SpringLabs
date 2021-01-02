package com.springlabs.pizzastore.domain;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * This class manages the spring's UserDetails bean
 * @author johne
 *
 */
public class CustomSecurityUser extends UserAccount implements UserDetails {

	private static final long serialVersionUID = -4381938875186527688L;

	public CustomSecurityUser() {
	}

	public CustomSecurityUser(UserAccount user) {
		//these setter calls are needed
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setPassword(user.getPassword());
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setDisplayName(user.getDisplayName());
		this.setYearOfBirth(user.getYearOfBirth());
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}