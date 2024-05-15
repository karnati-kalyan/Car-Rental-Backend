package com.fsd.Car_Rental_BackEnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.fsd.Car_Rental_BackEnd.entity.User;
import org.springframework.data.jpa.repository.Query;


import java.util.*;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    @Query("SELECT user FROM User user")
    List<User> findAllUsers();

}

