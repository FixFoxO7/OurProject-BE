package com.loginExercise.dal;

import com.loginExercise.dto.SuccessfulLoginDetails;
import com.loginExercise.dto.UserDto;
import com.loginExercise.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsersDal extends CrudRepository<User,Long> {
    @Query("SELECT new com.loginExercise.dto.SuccessfulLoginDetails(u.id) " +
            "FROM User u WHERE u.userName= :userName AND u.password= :password")
    SuccessfulLoginDetails login(@Param("userName") String userName, @Param("password") String password);

    @Query("SELECT new com.loginExercise.dto.UserDto(u.id,u.userName,u.age,u.gender) " +
            "FROM User u WHERE u.id= :id")
    UserDto getById(@Param("id") Long id);

//    @Query("SELECT new com.loginExercise.dto.UserDto(u.id,u.userName,u.age,u.gender) " +
//            "FROM User u ")
//    List<UserDto> getAll();

    List<User> findAll();

    User findByUserName(String name);
    User findById(long id);
}
