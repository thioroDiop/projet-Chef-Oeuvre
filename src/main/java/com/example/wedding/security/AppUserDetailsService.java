package com.example.wedding.security;

import com.example.wedding.models.AppUsers;
import com.example.wedding.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("userDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<AppUsers> user = appUserRepository.findByUsernameIgnoreCase(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("AppUser '" + username + "' not found");
        }

        return User
                .withUsername(username)
                .password(user.get().getPassword())
                .authorities(user.get().getRoleList())
                .build();
    }

    public Optional<AppUsers> loadAppUserByUsername(String username) {
        return appUserRepository.findByUsernameIgnoreCase(username);
    }
}
