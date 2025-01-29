package dev.udhayakumar.leave_portal.Leave;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@Controller
public class LeaveController {

    Logger logger = LoggerFactory.getLogger(LeaveController.class);

    @Autowired
    LeaveService leaveService;

    @Operation(summary = "To Submit New Leave")
    @PostMapping("/api/leave")
    public HttpEntity<Object> applyLeave(@Valid @RequestBody ApplyLeaveRequestDto newLeave) {
        logger.info("Controller-Request: POST /api/leave with body {}",newLeave);
        try{
            String leaveId = leaveService.applyLeave(newLeave);
            String location = "/api/leave/"+leaveId;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(URI.create(location));
            logger.info("Controller-Response: Leave Posted Successfully {}",newLeave);
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body("");
        } catch (Exception e) {
            logger.error("Controller-Response: Failed to Post Leave {}, error {}",newLeave,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Apply Leave");
        }
    }

    @Operation(summary = "To Fetch Leave By ID")
    @GetMapping("/api/leave/{id}")
    public HttpEntity<Object> viewLeave(@PathVariable String id){
        logger.info("Controller-Request: GET /api/leave/{}",id);
        try{
            ViewLeaveResponseDto leaveResponseDto = leaveService.fetchLeave(id);
            logger.info("Controller-Response: Leave Fetched Successfully {}",leaveResponseDto.toString());
            return ResponseEntity.status(HttpStatus.OK).body(leaveResponseDto);
        } catch (Exception e) {
            logger.error("Controller-Response: Failed to Fetch the leave {} error {}",id,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/api/leave/user/{userName}")
    public HttpEntity<Object> viewAllLeave(@PathVariable String userName){
        logger.info("Controller-Request: GET /api/leave/user/{}",userName);
        try{
            List<ViewLeaveResponseDto> viewLeaveResponseDtos = leaveService.fetchAllLeave(userName);
            logger.info("Controller-Response: Leave Fetched Successfully");
            return ResponseEntity.status(HttpStatus.OK).body(viewLeaveResponseDtos);
        } catch (Exception e) {
            logger.error("Controller-Response: Failed to Fetch the leave {} error {}",userName,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
