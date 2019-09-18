package com.clari5.entity.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "srilankan")
@DiscriminatorValue("srilanka")
public class SLCustomer extends Customer {

    @Column(length = 100)
    private String nationalId;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
