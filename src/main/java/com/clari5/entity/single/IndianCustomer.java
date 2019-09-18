package com.clari5.entity.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "indian")
@DiscriminatorValue("india")
public class IndianCustomer extends Customer {

    @Column(length = 100)
    private String aadhar;

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
}
