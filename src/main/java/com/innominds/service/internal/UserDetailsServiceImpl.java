package com.innominds.service.internal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tvajjala.builder.UserBuilder;

public class UserDetailsServiceImpl implements UserDetailsService {

    // TODO: Replace this code with DATABASE or OTHER MECHANISUM TO LOAD

    private final Map<String, UserDetails> usersMap = new HashMap<>();

    {
        usersMap.put("admin", UserBuilder.createUser().withUsername("admin").password("1234").havingRoles("ROLE_ADMIN").build());
        usersMap.put("tvajjala", UserBuilder.createUser().withUsername("tvajjala").password("1234").havingRoles("ROLE_USER", "ROLE_MANAGER").build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final UserDetails userDetails = usersMap.get(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException(String.format("No user exists with username %s ", username));
            // Bad Credentials
        }

        return userDetails;
    }

}
