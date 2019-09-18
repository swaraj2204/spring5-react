package com.clari5.entity.joined;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acctId;
    private Date acctOpenDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }
}
