package com.springlabs.pizzastore.service.impl;


import com.springlabs.pizzastore.domain.CustomSecurityUser;
import com.springlabs.pizzastore.domain.UserAccount;
import com.springlabs.pizzastore.repository.UserRepository;
import com.springlabs.pizzastore.repository.impl.JpaUserRepository;
import com.springlabs.pizzastore.service.UserAccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountDetailsServiceImpl implements UserAccountDetailsService {
	
	@Autowired
	private JpaUserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//we don't use username's only emails
		//unfortunately Spring only supports this (loadUserByUsername) by default
		//Note that this requires mentioning in the Spring Security `.usernameParameter("email")`
		UserAccount user = userRepository.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("User account not found in the application");
		}
		return new CustomSecurityUser(user);
		
	}

	@Override
	public List<UserAccount> findAllUsers() {
		List<UserAccount> userAccountList = userRepository.findAll();
		return userAccountList;
	}

	@Override
	public UserAccount findById(long id) {
		Optional<UserAccount> userAccount = userRepository.findById(id);
		if(!userAccount.isPresent()) {
			throw new UsernameNotFoundException("User account not found in the application");
		}
		return userAccount.get();
	}

	@Override
	public boolean isUserExist(UserAccount user) {
		boolean userExists = false;
		if (user.getId() != null && user.getId() != 0) {
			userExists = userRepository.existsById(user.getId());
		} else {
			if (userRepository.findByEmail(user.getEmail()) != null) {
				userExists = true;
			}
		}
		return userExists;
	}

	@Override
	public void saveUser(UserAccount user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(UserAccount currentUser) {
		userRepository.save(currentUser);
	}

	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
}