package dev.udhayakumar.leave_portal.UserDetails;

public class UserDetailsAuthResponseDto {
    String username;
    String firstname;
    String lastname;
    boolean status;

    public UserDetailsAuthResponseDto(String username, String firstname, String lastname, boolean status) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
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
}
