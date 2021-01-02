package com.springlabs.pizzastore.controller;

import com.springlabs.pizzastore.service.PizzaService;
import com.springlabs.pizzastore.service.UserAccountDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PizzaService pizzaService;

    @Autowired
    UserAccountDetailsService userAccountDetailsService;

    @GetMapping("/login")
    public String loginPage() {
        logger.info("User controller");
        return "user/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        logger.info("User controller");
        return "user/register";
    }

    @PostMapping("/login")
    public String login() {
        logger.info("User controller");
        logger.info("User login initiated");
        return "pizza/pizzaList";
    }

    @PostMapping("/register")
    public String register() {
        logger.info("User controller");
        logger.info("User registration initiated");
        return "user/profile";
    }

    @PostMapping("/update")
    public String update() {
        logger.info("User controller");
        logger.info("User profile update initiated");
        return "user/profile";
    }
}
