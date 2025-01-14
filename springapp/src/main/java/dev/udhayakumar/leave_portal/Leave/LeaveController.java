package dev.udhayakumar.leave_portal.Leave;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LeaveController {

    Logger logger = LoggerFactory.getLogger(LeaveController.class);

    @Autowired
    LeaveService leaveService;

    @PostMapping("/api/leave")
    public HttpEntity<Object> applyLeave(@RequestBody ApplyLeaveRequestDto newLeave) {
        logger.info("Controller-Request: POST /api/leave with body {}",newLeave);
        try{
            leaveService.applyLeave(newLeave);
            logger.info("Controller-Response: Leave Posted Successfully {}",newLeave);
            return ResponseEntity.status(HttpStatus.CREATED).body("");
        } catch (Exception e) {
            logger.error("Controller-Response: Failed to Post Leave {}, error {}",newLeave,e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Apply Leave");
        }

    }


}
