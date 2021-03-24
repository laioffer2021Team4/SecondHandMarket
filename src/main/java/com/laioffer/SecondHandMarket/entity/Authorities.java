package com.laioffer.SecondHandMarket.entity;

public class Authorities {
    private String emailId;
    private UserRole role;

    public String getEmailId() {
        return emailId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
