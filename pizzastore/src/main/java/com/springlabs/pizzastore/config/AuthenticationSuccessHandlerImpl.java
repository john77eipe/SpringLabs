package com.springlabs.pizzastore.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author John Eipe
 * 
 */
@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
    	 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		 for (GrantedAuthority grantedAuthority : authorities) {
		     if (grantedAuthority.getAuthority().equals("ROLE_ADMIN") || grantedAuthority.getAuthority().equals("ROLE_OWNER")) {
		    	 redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/user/profilePage");
			 } else {
		    	 redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/user/profilePage");
			 }
			 break;
		 }
      
        
    }
}