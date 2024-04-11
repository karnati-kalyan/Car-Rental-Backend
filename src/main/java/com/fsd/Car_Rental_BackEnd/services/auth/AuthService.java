package com.fsd.Car_Rental_BackEnd.services.auth;

import com.fsd.Car_Rental_BackEnd.dto.RegisterRequest;
import com.fsd.Car_Rental_BackEnd.dto.UserDto;

public interface AuthService {

    UserDto createUser(RegisterRequest registerRequest);

    boolean emailExists(String email);
}
