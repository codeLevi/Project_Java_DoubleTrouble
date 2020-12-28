package com.projfinal.agentie.model;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
    @NotEmpty(message = "Introduceţi Prenumele")
    private String firstName;
    @NotEmpty(message = "Introduceţi Numele")
    private String lastName;
    @NotEmpty(message = "Introduceţi Adresa de Email")
    private String email;
    @NotEmpty(message = "Introduceţi Parola")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
