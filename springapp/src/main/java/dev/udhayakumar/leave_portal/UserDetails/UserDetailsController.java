package dev.udhayakumar.leave_portal.UserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;
import java.util.Optional;


@Controller
public class UserDetailsController {
    Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/createUser")
    public HttpEntity<Object> createUser(@RequestBody UserDetails newUser){
        userDetailsService.save(newUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showAll")
    public HttpEntity<Object> showAll(){
        return new ResponseEntity<Object>(userDetailsService.showAll(),HttpStatus.OK);
    }

    @PostMapping("/auth")
    public HttpEntity<Object> verifyUser(@RequestBody UserDetailsAuthRequestDto userDetailsAuthRequestDto){

        logger.info(userDetailsAuthRequestDto.toString());
        Optional<UserDetails> userDetails = userDetailsService.authUser(userDetailsAuthRequestDto.username, userDetailsAuthRequestDto.password);
        logger.info(userDetails.get().toString());
        if(userDetails.isPresent() && Objects.equals(userDetailsAuthRequestDto.password, userDetails.get().getPassword())){
            return new ResponseEntity<>(new UserDetailsAuthResponseDto(
                    userDetails.get().getUserName(),
                    userDetails.get().getFirstName(),
                    userDetails.get().getLastName(),
                    userDetails.get().getStatus()
            ), HttpStatus.OK);
        }else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Error", "Invalid username or password");
            return new ResponseEntity<>(headers, HttpStatus.UNAUTHORIZED);
        }
    }
}
