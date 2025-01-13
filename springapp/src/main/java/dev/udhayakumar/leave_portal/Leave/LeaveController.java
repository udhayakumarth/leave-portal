package dev.udhayakumar.leave_portal.Leave;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LeaveController {

    //To-do
    public HttpEntity<Object> applyLeave(@RequestBody ApplyLeaveRequestDto newLeave) {
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
    

}
