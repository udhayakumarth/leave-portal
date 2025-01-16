package dev.udhayakumar.leave_portal.Leave;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class ApplyLeaveRequestDto {

    @NotBlank(message = "{error.field.required}")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{error.field.invalid.date}")
    String leaveFrom;

    @NotBlank(message = "{error.field.required}")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{error.field.invalid.date}")
    String leaveTo;

    @NotBlank(message = "{error.field.required}")
    String leaveType;

    @NotBlank(message = "{error.field.required}")
    String comments;

    @NotBlank(message = "{error.field.required}")
    String userName;

    public String getLeaveFrom() {
        return leaveFrom;
    }

    public void setLeaveFrom(String leaveFrom) {
        this.leaveFrom = leaveFrom;
    }

    public String getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(String leaveTo) {
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
