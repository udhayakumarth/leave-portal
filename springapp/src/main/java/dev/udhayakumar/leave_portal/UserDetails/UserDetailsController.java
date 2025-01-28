package dev.udhayakumar.leave_portal.UserDetails;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserDetailsController {
    Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
    @Autowired
    UserDetailsService userDetailsService;

    @Operation(summary = "Create a new user")
    @PostMapping("/api/users")
    public HttpEntity<Object> saveUser(@RequestBody @Valid UserDetailsRequestDto newUser){
        logger.info("Controller-Request: POST /api/v1/users with Body: {}",newUser);
        try{
            userDetailsService.saveUser(newUser);
            logger.info("Controller-Response: User Created Successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }catch (Exception e){
            logger.error("Controller-Response: Failed to Create User: {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create User");
        }
    }

    @Operation(summary = "Authenticate user")
    @PostMapping("/api/users/auth")
    public HttpEntity<Object> verifyUser(@RequestBody @Valid UserDetailsAuthRequestDto userDetailsAuthRequestDto){
        logger.info("Controller-Request: POST /api/v1/auth username: {}",userDetailsAuthRequestDto.getUsername());
        try{
            UserDetailsAuthResponseDto userDetailsAuthResponseDto = userDetailsService.authUser(userDetailsAuthRequestDto.username, userDetailsAuthRequestDto.password);
            logger.info("Controller-Response: Authentication Successful for user {}",userDetailsAuthResponseDto.toString());
            return ResponseEntity.status(HttpStatus.OK).body(userDetailsAuthResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
