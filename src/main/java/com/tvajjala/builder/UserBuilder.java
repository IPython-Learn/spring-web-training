package com.tvajjala.builder;

import org.springframework.security.core.userdetails.UserDetails;

import com.tvajjala.vo.Authority;
import com.tvajjala.vo.User;

public class UserBuilder {

    private String username;

    private String password;

    private String[] roles;

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder havingRoles(String... roles) {
        this.roles = roles;

        return this;
    }

    public UserDetails build() {

        final User user = new User(username, password);

        for (final String role : roles) {
            user.addAuthority(new Authority(role));
        }

        return user;
    }

}
