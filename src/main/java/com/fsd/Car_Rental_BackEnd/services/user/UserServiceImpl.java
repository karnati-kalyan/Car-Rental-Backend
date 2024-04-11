package com.fsd.Car_Rental_BackEnd.services.user;


import java.lang.reflect.Array;
import java.util.*;
import com.fsd.Car_Rental_BackEnd.dto.UserDto;
import com.fsd.Car_Rental_BackEnd.entity.User;
import com.fsd.Car_Rental_BackEnd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.findAllUsers();
    }

    @Override
    public User findUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return userOptional.get();
        } else {
            return null;
        }
    }


}
