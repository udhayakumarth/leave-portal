package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import javax.xml.crypto.Data;
import java.util.Date;

public class ApplyLeaveRequestDto {
    Data leaveFrom;
    Date leaveTo;
    String leaveType;
    String comments;
    String status;
    String userName;



    public Data getLeaveFrom() {
        return leaveFrom;
    }

    public void setLeaveFrom(Data leaveFrom) {
        this.leaveFrom = leaveFrom;
    }

    public Date getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(Date leaveTo) {
        this.leaveTo = leaveTo;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
