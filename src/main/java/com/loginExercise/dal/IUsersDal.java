package com.loginExercise.dal;

import com.loginExercise.dto.SuccessfulLoginDetails;
import com.loginExercise.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUsersDal extends CrudRepository<User,Long> {
    @Query("SELECT new com.loginExercise.dto.SuccessfulLoginDetails(u.id) " +
            "FROM User u WHERE u.userName= :userName AND u.password= :password")
    SuccessfulLoginDetails login(@Param("userName") String userName, @Param("password") String password);
}
