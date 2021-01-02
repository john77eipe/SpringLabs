package com.springlabs.pizzastore.repository;

import com.springlabs.pizzastore.domain.UserAccount;

public interface UserRepository {
    UserAccount findByEmail(String email);
}
