package com.fsd.Car_Rental_BackEnd.entity;


import com.fsd.Car_Rental_BackEnd.enums.UserRole;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String email;

    private UserRole userRole;

}
