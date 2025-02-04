package dev.udhayakumar.leave_portal.UserDetails;

import jakarta.validation.constraints.NotBlank;

public class UserDetailsAuthRequestDto {

    @NotBlank(message = "{error.field.required.userName}")
    String username;

    @NotBlank(message = "{error.field.required.password}")
    String password;

    public UserDetailsAuthRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDetailsAuthRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
