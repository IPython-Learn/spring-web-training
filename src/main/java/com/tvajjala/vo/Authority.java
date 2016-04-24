package com.tvajjala.vo;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = -3506967259054761613L;

    public Authority() {

    }

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {

        return authority;
    }

}
