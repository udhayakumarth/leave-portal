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

    public void saveUser(UserDetailsRequestDto newUser) {
        logger.info("Service: saveUser Called with input: {}",newUser);
        try{
            UserDetails newUserDetails = new UserDetails(
                    newUser.getUserName(),
                    newUser.getPassword(),
                    "staff",
                    newUser.getFirstName(),
                    newUser.getLastName()
            );
            userDetailsRepository.save(newUserDetails);
            logger.info("Service: User saved successfully: {}",newUser);
        }catch (Exception e){
            logger.error("Service: Failed to save user: {}",e.getMessage(),e);
            throw new RuntimeException("Failed to save user",e);
        }
    }

    public UserDetailsAuthResponseDto authUser(String username, String password) {
        logger.info("Service: authUser Called for user: {}",username);
        try{
            Optional<UserDetails> userDetails = userDetailsRepository.findByUserName(username);
            logger.info("Service: User Fetched Successfully: {}",username);
            try{
                if(userDetails.isPresent() && password.equals(userDetails.get().getPassword())){
                    logger.info("Service: User Authenticated Successfully: {}",username+password);
                    return new UserDetailsAuthResponseDto(userDetails.get().getUserName(),
                            userDetails.get().getFirstName(),
                            userDetails.get().getLastName(),
                            userDetails.get().getStatus(),
                            userDetails.get().getCreatedAt());
                }else {
                    throw new RuntimeException("Authentication Failed");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            logger.error("Service: Authentication Failed: {}",e.getMessage(),e);
            throw new RuntimeException("Invalid username or password");
        }
    }

    public Optional<UserDetails> getUserDetailsByUserName(String username) {
        return userDetailsRepository.findByUserName(username);
    }
}
