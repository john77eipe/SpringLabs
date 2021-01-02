package com.springlabs.pizzastore.service;

import com.springlabs.pizzastore.domain.UserAccount;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserAccountDetailsService extends UserDetailsService {
    List<UserAccount> findAllUsers();

    UserAccount findById(long id);

    boolean isUserExist(UserAccount user);

    void saveUser(UserAccount user);

    void updateUser(UserAccount currentUser);

    void deleteUserById(long id);

    void deleteAllUsers();
}
