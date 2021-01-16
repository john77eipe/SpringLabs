package com.springlabs.pizzastore.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author John Eipe
 * @EnableGlobalMethodSecurity is needed for method level security specification
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
       
    	
		//Note that the order of the antMatchers() elements is significant 
		//the more specific rules need to come first, followed by the more general ones
		httpSecurity
		//.csrf().disable()
		.authorizeRequests()
	        .antMatchers("/loginPage").permitAll()
			.antMatchers("/register/**").permitAll()
	        .antMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
	        .and()
	        .formLogin()
		        .loginPage("/loginPage")
		        .loginProcessingUrl("/login")
				.usernameParameter("email")  //since we use email and not username as the principal of authentication
	        .failureHandler(authenticationFailureHandler)
	        .successHandler(authenticationSuccessHandler)
	        .and()
		        .logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
				.logoutSuccessUrl("/")
	        .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}