package com.springlabs.pizzastore.controller;

import com.springlabs.pizzastore.domain.Authorities;
import com.springlabs.pizzastore.domain.UserAccount;
import com.springlabs.pizzastore.dto.SignupRequestDTO;
import com.springlabs.pizzastore.service.UserAccountDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserAccountDetailsService userAccountDetailsService;

    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/loginPage")
    public String loginPage() {
        logger.info("User controller");
        return "user/login";
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        logger.info("User controller");
        return "user/register";
    }

    @GetMapping("/profilePage")
    public String profilePage() {
        logger.info("User controller");
        return "user/profile";
    }


    @PostMapping("/register")
    public String register(SignupRequestDTO signupRequest) {
        logger.info("User controller");
        logger.info("User registration initiated");
        // Create new user's account
        System.out.println("Creating User " + signupRequest);

//        if (userAccountDetailsService..isUserExistByUsername(signupRequest.getUsername())) {
//            System.out.println("A User with username: " + signupRequest.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        UserAccount userAccount = new UserAccount();
        userAccount.setDisplayName(signupRequest.getDisplayName());
        userAccount.setEmail(signupRequest.getEmail());
        userAccount.setFirstName(signupRequest.getFirstName());
        userAccount.setYearOfBirth(signupRequest.getYearOfBirth());
        userAccount.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        Authorities authority = new Authorities();
        authority.setAuthority("ROLE_CUSTOMER"); //default role
        Set<Authorities> authorities = new HashSet<>();
        authority.setUserAccount(userAccount);
        authorities.add(authority);
        userAccount.setAuthorities(authorities);

        userAccountDetailsService.saveUser(userAccount);
        return "user/profilePage";
    }

    @PostMapping("/update")
    public String update() {
        logger.info("User controller");
        logger.info("User profile update initiated");
        return "user/profilePage";
    }
}
