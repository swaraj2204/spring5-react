package com.clari5.entity.single;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cust_country")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String customerName;
    private Date custDob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustDob() {
        return custDob;
    }

    public void setCustDob(Date custDob) {
        this.custDob = custDob;
    }
}
