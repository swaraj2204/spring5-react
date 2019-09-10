package com.clari5.crud;

import com.clari5.entity.mod.UserMod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModCrud extends CrudRepository<UserMod,Integer> {

    UserMod getUserByUserId(String userId);
}
