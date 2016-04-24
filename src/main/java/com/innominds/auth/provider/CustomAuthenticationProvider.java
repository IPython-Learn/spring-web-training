package com.innominds.auth.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication userEnteredDetails) throws AuthenticationException {

        final UserDetails details = userDetailsService.loadUserByUsername(userEnteredDetails.getName());

        if (!isPasswordCorrect(userEnteredDetails, details)) {
            throw new BadCredentialsException("Bad credentials");
        }

        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(details.getUsername(), details.getPassword(),
                details.getAuthorities());

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    boolean isPasswordCorrect(Authentication userEnteredDetails, UserDetails actualDetails) {

        final String userEnteredPassword = userEnteredDetails.getCredentials().toString();

        final String actualPassword = actualDetails.getPassword();

        System.err.println("UserEnteredPassword " + userEnteredPassword);
        if (userEnteredPassword == null || userEnteredPassword.trim().length() < 1) {
            // return false;// This makes user must enter password to proceed . you can throw Password required kind of exception of
            throw new BadCredentialsException("Please enter password");
        }

        if (userEnteredPassword != null && actualPassword != null) {
            return userEnteredPassword.equals(actualPassword);
        }

        return false;

    }

}
