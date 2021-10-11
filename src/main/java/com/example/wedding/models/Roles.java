package com.example.wedding.models;
import org.springframework.security.core.GrantedAuthority;

/**
 * User possible roles.
 */
public enum Roles implements GrantedAuthority {
    ROLE_ADMIN, ROLE_GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}