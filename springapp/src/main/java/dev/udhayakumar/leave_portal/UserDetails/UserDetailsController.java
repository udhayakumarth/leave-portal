package dev.udhayakumar.leave_portal.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Controller
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/createUser")
    public HttpEntity<Object> createUser(@RequestBody UserDetails newUser){
        userDetailsService.save(newUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/auth")
    public HttpEntity<Object> verifyUser(@RequestBody UserDetailsAuthRequestDto userDetailsAuthRequestDto){
        UserDetails userDetails = userDetailsService.authUser(userDetailsAuthRequestDto.username, userDetailsAuthRequestDto.password);
        if(userDetails != null && Objects.equals(userDetailsAuthRequestDto.password, userDetails.getPassword())){
            return new ResponseEntity<>(new UserDetailsAuthResponseDto(
                    userDetails.getUserName(),
                    userDetails.getFirstname(),
                    userDetails.getLastname(),
                    userDetails.getStatus()
            ), HttpStatus.OK);
        }else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Error", "Invalid username or password");
            return new ResponseEntity<>(headers, HttpStatus.UNAUTHORIZED);
        }
    }
}
