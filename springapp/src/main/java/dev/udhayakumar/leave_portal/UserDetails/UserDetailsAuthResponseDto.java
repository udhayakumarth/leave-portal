package dev.udhayakumar.leave_portal.UserDetails;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class UserDetailsAuthResponseDto {
    String username;
    String firstname;
    String lastname;
    boolean status;
    Date createdAt;

    public UserDetailsAuthResponseDto(String username, String firstname, String lastname, boolean status,Date createdAt) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDetailsAuthResponseDto{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
