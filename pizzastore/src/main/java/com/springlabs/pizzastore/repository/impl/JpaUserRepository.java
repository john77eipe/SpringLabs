package com.springlabs.pizzastore.repository.impl;

import com.springlabs.pizzastore.domain.UserAccount;
import com.springlabs.pizzastore.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaUserRepository extends JpaRepository<UserAccount, Long>, UserRepository {

    @Query("select u from UserAccount u"
            + " left join fetch u.authorities"
            + " where u.email = :email")
    UserAccount findByEmail(String email);
}
