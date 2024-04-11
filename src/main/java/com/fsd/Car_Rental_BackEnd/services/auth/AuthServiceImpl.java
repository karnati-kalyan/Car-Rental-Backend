package com.fsd.Car_Rental_BackEnd.services.auth;

import com.fsd.Car_Rental_BackEnd.dto.RegisterRequest;
import com.fsd.Car_Rental_BackEnd.dto.UserDto;
import com.fsd.Car_Rental_BackEnd.entity.User;
import com.fsd.Car_Rental_BackEnd.enums.UserRole;
import com.fsd.Car_Rental_BackEnd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(RegisterRequest registerRequest){
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setUserRole(UserRole.USER);

        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        userDto.setUserName(createdUser.getUserName());
        userDto.setUserRole(createdUser.getUserRole());
        userDto.setEmail(createdUser.getEmail());

        return userDto;
    }

    @Override
    public boolean emailExists(String email){
        return userRepository.findUserByEmail(email).isPresent();
    }
}
