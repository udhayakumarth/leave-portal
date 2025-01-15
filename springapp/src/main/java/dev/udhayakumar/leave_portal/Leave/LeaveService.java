package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import dev.udhayakumar.leave_portal.UserDetails.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepository;
    UserDetailsService userDetailsService;

    Logger logger = LoggerFactory.getLogger(LeaveService.class);

    public String applyLeave(ApplyLeaveRequestDto newLeave) {
        logger.info("Service: applyLeave for {}",newLeave.toString());
        try {
            Optional<UserDetails> userDetails = userDetailsService.getUserDetailsByUserName(newLeave.getUserName());
            if(userDetails.isPresent()){
                Leave leave = new Leave(
                        newLeave.getLeaveFrom(),
                        newLeave.getLeaveTo(),
                        newLeave.getLeaveType(),
                        newLeave.getComments(),
                        "Pending",
                        userDetails.get()
                );
                leaveRepository.save(leave);
                logger.info("Service: Leave posted successfully with id {}",leave.getId());
                return leave.getId();
            }
            return null;
        } catch (RuntimeException e) {
            logger.error("Service: Error posting leave {}",newLeave.toString());
            throw new RuntimeException(e);
        }
    }

    public ViewLeaveResponseDto fetchLeave(String id) {
        logger.info("Service: fetchLeave for {}",id);
        try{
            Optional<Leave> leave = leaveRepository.findById(id);
            return leave.map(value -> new ViewLeaveResponseDto(
                    value.getId(),
                    value.getLeaveFrom(),
                    value.getLeaveTo(),
                    value.getLeaveType(),
                    value.getComments(),
                    value.getStatus(),
                    value.getUser().getUserName(),
                    value.getApprovedAt(),
                    value.getCreatedAt(),
                    value.getModifiedAt()
            )).orElse(null);
        } catch (Exception e) {
            logger.error("Service: Error Fetching Leave {}, error {}",id,e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
