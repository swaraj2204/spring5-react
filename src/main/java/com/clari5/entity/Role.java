package com.clari5.entity;

import javax.persistence.*;

@Entity
@Table(name = "CL5_ROLE_TBL")
public class Role {

    public enum RoleType{
        ADMIN, VALIDATOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Long rvn;

    @Column(unique = true, length = 100)
    private String roleId;

    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private RoleType role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
