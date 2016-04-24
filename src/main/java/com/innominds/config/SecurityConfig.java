package com.innominds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.innominds.auth.provider.CustomAuthenticationProvider;
import com.innominds.service.internal.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
// @EnableWebSecurity looks for instance of class WebSecurityConfigurerAdapter to read the settings
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/secure/**").hasRole("ADMIN").and().formLogin().and().logout().logoutUrl("/logout");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(false);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");

        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

}
