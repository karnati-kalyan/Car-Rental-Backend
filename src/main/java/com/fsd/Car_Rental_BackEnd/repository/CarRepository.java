package com.fsd.Car_Rental_BackEnd.repository;

import com.fsd.Car_Rental_BackEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fsd.Car_Rental_BackEnd.entity.Car;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {


    @Query("SELECT car FROM Car car")
    List<Car> findAllCars();
}
