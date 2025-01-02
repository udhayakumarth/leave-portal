package dev.udhayakumar.leave_portal.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsRepository.findByUsername();
    }
}
