package com.fsd.Car_Rental_BackEnd.controller;

import com.fsd.Car_Rental_BackEnd.dto.CarDto;
import com.fsd.Car_Rental_BackEnd.dto.RegisterRequest;
import com.fsd.Car_Rental_BackEnd.dto.UserDto;
import com.fsd.Car_Rental_BackEnd.entity.Car;
import com.fsd.Car_Rental_BackEnd.services.car.carService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class CarController {

    private final carService carService;

    @GetMapping("/cars")
    public ResponseEntity<?> getCars()
    {
        List<Car> cars = carService.getCars();
        return new ResponseEntity<>(cars, HttpStatus.ACCEPTED);
    }

    @PostMapping("/createCar")
    public ResponseEntity<?> createCar(@RequestBody CarDto carDto)
    {

        CarDto createdCarDto = carService.createCar(carDto);
        if(createdCarDto == null)
        {
            return new ResponseEntity<>("car Not created due to issues", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdCarDto,HttpStatus.CREATED);
    }
}
