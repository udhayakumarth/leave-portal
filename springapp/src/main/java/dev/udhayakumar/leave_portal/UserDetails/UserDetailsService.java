package dev.udhayakumar.leave_portal.UserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

    public void saveUser(UserDetails newUser) {
        logger.info("Service: saveUser Called with input: {}",newUser);
        try{
            userDetailsRepository.save(newUser);
            logger.info("Service: User saved successfully: {}",newUser);
        }catch (Exception e){
            logger.error("Service: Failed to save user: {}",e.getMessage(),e);
            throw new RuntimeException("Failed to save user",e);
        }
    }

    public boolean authUser(String username, String password) {
        Optional<UserDetails> userDetails = userDetailsRepository.findByUserName(username);
        return userDetails.filter(details -> password.equals(details.getPassword())).isPresent();
    }


    public Object getUserDetails(String username) {
        return userDetailsRepository.findByUserName(username);
    }
}
