package dev.udhayakumar.leave_portal.Leave;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LeaveMapper {

    static Logger logger = LoggerFactory.getLogger(LeaveMapper.class);
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    // ISO 8601 DateTime Formatter
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static Leave toEntity(ApplyLeaveRequestDto applyLeaveRequestDto){
        logger.info("LeaveMapper-toEntity: {}",applyLeaveRequestDto);
        try{
            Leave leave = new Leave(
                    stringToDate(applyLeaveRequestDto.getLeaveFrom()),
                    stringToDate(applyLeaveRequestDto.getLeaveTo()),
                    applyLeaveRequestDto.getLeaveType(),
                    applyLeaveRequestDto.getComments()
            );
            logger.info("LeaveMapper-toEntity: {}",leave.toString());
            return leave;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static ViewLeaveResponseDto toDto(Leave leave){
        try{
            return new ViewLeaveResponseDto(
                    leave.getId(),
                    dateToString(leave.getLeaveFrom()),
                    dateToString(leave.getLeaveTo()),
                    leave.getLeaveType(),
                    leave.getComments(),
                    leave.getStatus(),
                    leave.getUser().getUserName(),
                    leave.getApprovedAt(),
                    leave.getCreatedAt(),
                    leave.getModifiedAt()
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date stringToDate(String dateString) throws ParseException {
        logger.info("LeaveMapper-stringToDate: {}",dateString);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date date = formatter.parse(dateString);
        Date currentDate = new Date();
        logger.info("LeaveMapper-stringToDate: {}",date);
        logger.info("LeaveMapper-stringToDate: {}",currentDate);
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }
}
