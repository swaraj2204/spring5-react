package com.clari5.crud;

import com.clari5.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrud extends CrudRepository<User,Integer> {

    User getUserByUserId(String userId);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.userId = (:user_id) and u.tenant = (:tenant)")
    User findByUserIdAndTenantFetchRoleEagerly(@Param("user_id") String userId, @Param("tenant") String tenant);

}
