package com.fsd.Car_Rental_BackEnd.controller;

import com.fsd.Car_Rental_BackEnd.dto.RegisterRequest;
import com.fsd.Car_Rental_BackEnd.dto.UserDto;
import com.fsd.Car_Rental_BackEnd.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest)
    {
        if(authService.emailExists(registerRequest.getEmail()))
        {
            return new ResponseEntity<>("Email already exists", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto registeredUserDto = authService.createUser(registerRequest);
        if(registeredUserDto == null)
        {
            return new ResponseEntity<>("User Not created due to issues", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(registeredUserDto,HttpStatus.CREATED);
    }
}
