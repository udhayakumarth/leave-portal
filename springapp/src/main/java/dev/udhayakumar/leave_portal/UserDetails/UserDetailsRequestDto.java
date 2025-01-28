package dev.udhayakumar.leave_portal.UserDetails;


import jakarta.validation.constraints.NotBlank;

public class UserDetailsRequestDto {

    @NotBlank(message = "{error.field.required.userName}")
    private String userName;

    @NotBlank(message = "{error.field.required.password}")
    private String password;

    @NotBlank(message = "{error.field.required.firstName}")
    private String firstName;

    @NotBlank(message = "{error.field.required.lastName}")
    private String lastName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDetailsRequestDto{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
