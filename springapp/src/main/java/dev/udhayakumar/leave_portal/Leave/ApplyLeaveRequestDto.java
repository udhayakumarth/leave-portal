package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import javax.xml.crypto.Data;
import java.util.Date;

public class ApplyLeaveRequestDto {
    Date leaveFrom;
    Date leaveTo;
    String leaveType;
    String comments;
    String userName;



    public Date getLeaveFrom() {
        return leaveFrom;
    }

    public void setLeaveFrom(Date leaveFrom) {
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


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ApplyLeaveRequestDto{" +
                "leaveFrom=" + leaveFrom +
                ", leaveTo=" + leaveTo +
                ", leaveType='" + leaveType + '\'' +
                ", comments='" + comments + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
