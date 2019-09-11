package com.clari5.entity.mod;

import com.clari5.entity.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "CL5_USER_MOD_TBL")
public class UserMod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Long rvn;

    @NotEmpty(message = "{user.id.non.empty}")
    @Column(nullable = false, unique = true, length = 10)
    private String userId;

    @NotEmpty()
    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, unique = true, length = 200)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 8)
    private String password;

    @Column(name = "created_on", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(length = 255)
    private String lastUpdatedBy;

    // This value should be set by database on insert
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;


    public UserMod setLastUpdatedBy(String uid) {
        this.lastUpdatedBy = uid;
        return this;
    }

    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public Date getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }


    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }


    public Integer getId() {
        return id;
    }

    public UserMod setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserMod setUserId(String u) {
        this.userId = u;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getRvn() {
        return rvn;
    }

    public void setRvn(Long rvn) {
        this.rvn = rvn;
    }


    public static UserMod from(User user) {
        UserMod um = new UserMod();
        um.setId(user.getId());
        // ...
        return um;
    }
}

