package dev.udhayakumar.leave_portal.UserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

    public void save(UserDetails newUser) {
        userDetailsRepository.save(newUser);
    }

    public Optional<UserDetails> authUser(String username, String password) {
        return userDetailsRepository.findByUserName(username);
    }


    public Object showAll() {
        return userDetailsRepository.findAll();
    }
}
