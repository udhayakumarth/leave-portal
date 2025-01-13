package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    Data leaveFrom;

    @Column(nullable = false)
    Date leaveTo;

    @Column(nullable = false)
    String leaveType;
    String comments;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    @ManyToOne
    UserDetails user;

    Date approvedAt;

    @Column(nullable = false)
    @CreatedDate
    Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    Date modifiedAt;

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

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

    public Date getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Date approvedAt) {
        this.approvedAt = approvedAt;
    }
}
