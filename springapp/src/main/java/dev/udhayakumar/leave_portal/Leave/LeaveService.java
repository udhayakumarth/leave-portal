package dev.udhayakumar.leave_portal.Leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    public void applyLeave(ApplyLeaveRequestDto newLeave) {
        try {
            //To-do
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
