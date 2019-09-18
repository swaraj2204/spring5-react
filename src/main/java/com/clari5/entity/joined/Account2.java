package com.clari5.entity.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account2")
public class Account2 extends Account {

    @Column(length = 100)
    private String accntBranchCode;

    public String getAccntBranchCode() {
        return accntBranchCode;
    }

    public void setAccntBranchCode(String accntBranchCode) {
        this.accntBranchCode = accntBranchCode;
    }
}
