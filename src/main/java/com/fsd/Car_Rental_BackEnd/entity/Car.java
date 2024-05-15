package com.fsd.Car_Rental_BackEnd.entity;

import com.fsd.Car_Rental_BackEnd.enums.CarType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String carCompany;

    private String carName;

    private boolean availableToday;

    private Double pricePerHour;

    private CarType carType;
}
