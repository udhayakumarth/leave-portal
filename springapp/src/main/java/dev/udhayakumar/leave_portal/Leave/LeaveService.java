package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import dev.udhayakumar.leave_portal.UserDetails.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    @Autowired
    UserDetailsService userDetailsService;

    Logger logger = LoggerFactory.getLogger(LeaveService.class);

    public String applyLeave(ApplyLeaveRequestDto newLeave) {
        logger.info("Service: applyLeave for {}",newLeave.toString());
        try {
            Optional<UserDetails> userDetails = userDetailsService.getUserDetailsByUserName(newLeave.getUserName());
            if(userDetails.isPresent()){
                Leave leave = LeaveMapper.toEntity(newLeave);
                leave.setUser(userDetails.get());
                leave.setStatus("Pending");
                logger.info("Final format leave: {}", leave.toString());
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
            return leave.map(LeaveMapper::toDto).orElse(null);
        } catch (Exception e) {
            logger.error("Service: Error Fetching Leave {}, error {}",id,e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<ViewLeaveResponseDto> fetchAllLeave(String userName) {
        logger.info("Service: fetchAllLeave for {}",userName);
        try {
            Optional<UserDetails> userDetails = userDetailsService.getUserDetailsByUserName(userName);
            if (userDetails.isPresent()){
                List<Leave> allLeavesByUser= leaveRepository.findAllByUser(userDetails.get());
                List<ViewLeaveResponseDto> allLeavesByUserDto = new ArrayList<>();
                for(Leave i : allLeavesByUser){
                    allLeavesByUserDto.add(LeaveMapper.toDto(i));
                }
                logger.info("Service: fetchAllLeave for {} success",userName);
                return allLeavesByUserDto;
            }
            return null;

        } catch (Exception e) {
            logger.error("Service: Error Fetching Leave {}, error {}",userName,e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
