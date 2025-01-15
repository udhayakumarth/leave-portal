package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    Date leaveFrom;

    @Column(nullable = false)
    Date leaveTo;

    @Column(nullable = false)
    String leaveType;
    String comments;

    @Column(nullable = false)
    String status;

    Date approvedAt;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    Date modifiedAt;

    @JoinColumn(nullable = false)
    @ManyToOne
    UserDetails user;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    public Leave(Date leaveFrom, Date leaveTo, String leaveType, String comments, String status, UserDetails user) {
        this.leaveFrom = leaveFrom;
        this.leaveTo = leaveTo;
        this.leaveType = leaveType;
        this.comments = comments;
        this.status = status;
        this.user = user;
    }

    public Leave() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

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

    @Override
    public String toString() {
        return "Leave{" +
                "id='" + id + '\'' +
                ", leaveFrom=" + leaveFrom +
                ", leaveTo=" + leaveTo +
                ", leaveType='" + leaveType + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", approvedAt=" + approvedAt +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
