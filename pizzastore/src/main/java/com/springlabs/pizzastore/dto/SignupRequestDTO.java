package com.springlabs.pizzastore.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Set;
import java.util.StringJoiner;

public class SignupRequestDTO {

    @NotBlank(message = "email must not be null")
    @Size(min = 2, max = 12, message = "username size must be between 2 and 12")
   // @Pattern(regexp = "[a-zA-Z0-9]+", message = "username must not contain special characters")
    private String email;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String displayName;

    @Column(name = "yob")
    private int yearOfBirth;

    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SignupRequestDTO.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("firstName='" + firstName + "'")
                .add("displayName='" + displayName + "'")
                .add("yearOfBirth=" + yearOfBirth)
                .add("role=" + role)
                .add("password='" + password + "'")
                .toString();
    }
}