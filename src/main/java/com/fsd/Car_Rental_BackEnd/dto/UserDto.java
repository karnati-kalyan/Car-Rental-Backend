package com.fsd.Car_Rental_BackEnd.dto;

import com.fsd.Car_Rental_BackEnd.enums.UserRole;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String userName;

    private String password;

    private String email;

    private UserRole userRole;
}
