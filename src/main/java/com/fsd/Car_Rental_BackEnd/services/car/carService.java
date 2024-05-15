package com.fsd.Car_Rental_BackEnd.services.car;

import com.fsd.Car_Rental_BackEnd.dto.CarDto;
import com.fsd.Car_Rental_BackEnd.entity.Car;

import java.util.*;

public interface carService {

   List<Car> getCars();

   CarDto createCar(CarDto carDto);
}
