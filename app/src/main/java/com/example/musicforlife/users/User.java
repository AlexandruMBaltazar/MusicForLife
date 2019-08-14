package com.example.musicforlife.users;

public class User {
    private String surename;
    private String forename;
    private String email;
    private String password;

    public User() {
    }

    public User(String surename, String forename, String email, String password) {
        this.surename = surename;
        this.forename = forename;
        this.email = email;
        this.password = password;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
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
