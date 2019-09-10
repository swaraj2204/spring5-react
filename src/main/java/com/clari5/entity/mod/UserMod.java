package com.clari5.entity.mod;

import com.clari5.entity.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "CL5_USER_MOD_TBL")
public class UserMod extends User {

    private String lastUpdatedBy;

    // This value should be set by database on insert
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;

    public static UserMod from(User user){
        UserMod um = new UserMod();
        um.setId(user.getId());
        // ...
        return um;
    }

    public UserMod setLastUpdatedBy(String uid){
        this.lastUpdatedBy = uid;
        return this;
    }

    public String getLastUpdatedBy(){
        return this.lastUpdatedBy;
    }

    public Date getLastUpdatedAt(){
        return this.lastUpdatedAt;
    }
}

