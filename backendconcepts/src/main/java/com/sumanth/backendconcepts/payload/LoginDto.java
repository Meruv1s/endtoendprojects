package com.sumanth.backendconcepts.payload;

public class LoginDto {

    public LoginDto(String email, String password) {
        this.email = email;
        Password = password;
    }

    public LoginDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String email;
    public String Password;
}
