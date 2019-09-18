package com.clari5.entity.joined;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account1")
public class Account1 extends Account{

    @Column(length = 100)
    private String acctName;

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }
}
