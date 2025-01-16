package dev.udhayakumar.leave_portal.Leave;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.util.Date;

public class ViewLeaveResponseDto {
    String id;
    String leaveFrom;
    String leaveTo;
    String leaveType;
    String comments;
    String status;
    String userName;
    Date approvedAt;
    Date createdAt;
    Date modifiedAt;

    public ViewLeaveResponseDto(String id, String leaveFrom, String leaveTo, String leaveType, String comments, String status, String userName, Date approvedAt, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.leaveFrom = leaveFrom;
        this.leaveTo = leaveTo;
        this.leaveType = leaveType;
        this.comments = comments;
        this.status = status;
        this.userName = userName;
        this.approvedAt = approvedAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Date approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "ViewLeaveResponseDto{" +
                "id='" + id + '\'' +
                ", leaveFrom=" + leaveFrom +
                ", leaveTo=" + leaveTo +
                ", leaveType='" + leaveType + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                ", userName='" + userName + '\'' +
                ", approvedAt=" + approvedAt +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
