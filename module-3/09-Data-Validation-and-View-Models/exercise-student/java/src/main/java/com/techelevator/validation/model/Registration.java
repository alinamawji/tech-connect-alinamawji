package com.techelevator.validation.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class Registration {
    @NotBlank(message = "First name is required")
    @Size(max = 20, message = "Max length of 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 20, message = "Max length of 20 characters")
    private String lastName;

    @NotBlank(message = "Email address is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    private String confirmationEmail;
    private boolean emailMatching;

    @AssertTrue(message = "Emails must match")
    public boolean isEmailMatching() {
        if (email != null) {
            return email.equals(confirmationEmail);
        }
        return true;
    }

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Min length of 8 characters")
    private String password;

    private String confirmationPassword;
    private boolean passwordMatching;
    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirmationPassword);
        }
        return true;
    }

    @NotBlank(message = "Birthday is required")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Birthday format is MM-DD-YYYY")
    private String birthday;

    @NotBlank(message = "Number of tickets is required")
    @Range(min = 1, max = 10, message = "Min ticket is 1, max is 10")
    private String tickets;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationEmail() {
        return confirmationEmail;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public boolean getEmailMatching() {
        return emailMatching;
    }

    public boolean getPasswordMatching() {
        return passwordMatching;
    }

    public String getTickets() {
        return tickets;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmationEmail(String confirmationEmail) {
        this.confirmationEmail = confirmationEmail;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    public void setEmailMatching(boolean emailMatching) {
        this.emailMatching = emailMatching;
    }

    public void setPasswordMatching(boolean passwordMatching) {
        this.passwordMatching = passwordMatching;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }
}
