package com.laioffer.SecondHandMarket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

    private static final long serialVersionUID = 5363304925486157336L;

    @Id
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
