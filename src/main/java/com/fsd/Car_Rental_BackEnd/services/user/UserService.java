package com.fsd.Car_Rental_BackEnd.services.user;

import com.fsd.Car_Rental_BackEnd.dto.UserDto;
import com.fsd.Car_Rental_BackEnd.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User findUser(Long id);

    User deleteUser(Long id);
}
