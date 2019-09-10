package com.clari5.repository;

import com.clari5.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {


    User getUserByUsername(String username);
}
