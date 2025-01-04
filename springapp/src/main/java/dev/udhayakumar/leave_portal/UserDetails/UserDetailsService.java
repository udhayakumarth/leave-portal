package dev.udhayakumar.leave_portal.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public void save(UserDetails newUser) {
        userDetailsRepository.save(newUser);
    }

    public UserDetails authUser(String username, String password) {
        return userDetailsRepository.findByUsername(username);
    }
}
