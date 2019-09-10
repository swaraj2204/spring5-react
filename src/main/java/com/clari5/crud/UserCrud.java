package com.clari5.crud;

import com.clari5.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrud extends CrudRepository<User,Integer> {

    User getUserByUserId(String userId);
}
