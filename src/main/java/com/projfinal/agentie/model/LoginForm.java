package com.projfinal.agentie.model;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty(message = "Introduceţi Adresa de Email")
    private String email;
    @NotEmpty(message = "Introduceţi parola")
    private String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
