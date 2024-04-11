package com.fsd.Car_Rental_BackEnd.repository;

import com.fsd.Car_Rental_BackEnd.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fsd.Car_Rental_BackEnd.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    User findUserById(Long id);

    @Query("SELECT user FROM User user")
    List<User> findAllUsers();

    Optional<User> deleteUserById( Long id);
}
