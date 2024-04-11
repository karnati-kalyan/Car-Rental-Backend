package com.fsd.Car_Rental_BackEnd.controller;


import com.fsd.Car_Rental_BackEnd.entity.User;
import com.fsd.Car_Rental_BackEnd.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UsersController {


    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<?> getUsers()
    {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUsers(@PathVariable Long id)
    {
        User user = userService.findUser(id);
        if(user != null)
        {
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No User with given details",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        User user =  userService.deleteUser(id);
        if(user != null)
        {
            return new ResponseEntity<>("User deleted with given details:"+user,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No User with given details",HttpStatus.BAD_REQUEST);
        }

    }

}
