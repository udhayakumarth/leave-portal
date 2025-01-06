package dev.udhayakumar.leave_portal.UserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserDetailsController {
    Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/api/v1/users")
    public HttpEntity<Object> saveUser(@RequestBody UserDetails newUser){
        logger.info("Controller: Received Request for /api/v1/users with Body: {}",newUser);
        try{
            userDetailsService.saveUser(newUser);
            logger.info("Controller: User Created Successfully: {}",newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }catch (Exception e){
            logger.error("Controller: Error Creating User: {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create User");
        }
    }

    @PostMapping("/api/v1/auth")
    public HttpEntity<Object> verifyUser(@RequestBody UserDetailsAuthRequestDto userDetailsAuthRequestDto){
        if(userDetailsService.authUser(userDetailsAuthRequestDto.username, userDetailsAuthRequestDto.password)){
            return new ResponseEntity<>(userDetailsService.getUserDetails(userDetailsAuthRequestDto.username),HttpStatus.OK);
        }else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Error", "Invalid username or password");
            return new ResponseEntity<>(headers, HttpStatus.UNAUTHORIZED);
        }
    }
}
