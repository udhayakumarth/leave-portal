package dev.udhayakumar.leave_portal.Leave;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class ApplyLeaveRequestDto {

    @NotBlank(message = "{error.field.required.leaveFrom}")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{error.field.invalid.date.leaveFrom}")
    String leaveFrom;

    @NotBlank(message = "{error.field.required.leaveTo}")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "{error.field.invalid.date.leaveTo}")
    String leaveTo;

    @NotBlank(message = "{error.field.required.leaveType}")
    String leaveType;

    @NotBlank(message = "{error.field.required.comments}")
    String comments;

    @NotBlank(message = "{error.field.required.userName}")
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
