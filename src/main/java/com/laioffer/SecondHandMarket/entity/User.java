package com.laioffer.SecondHandMarket.entity;

public class User {

    private String emailId;
    private String password;
    private boolean enabled;

    private Customer customer;

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
