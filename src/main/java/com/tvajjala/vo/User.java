package com.tvajjala.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = -3265303008714285879L;

    private final Collection<GrantedAuthority> authorities = new ArrayList<>();

    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.unmodifiableCollection(authorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // custom method
    public void addAuthority(GrantedAuthority authority) {
        authorities.add(authority);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [");
        if (authorities != null) {
            builder.append("authorities=");
            builder.append(authorities);
            builder.append(", ");
        }
        if (username != null) {
            builder.append("username=");
            builder.append(username);
            builder.append(", ");
        }
        if (password != null) {
            builder.append("password=");
            builder.append("[PROTECTED]"); // best practice not to print password on logs
        }
        builder.append("]");
        return builder.toString();
    }

}
