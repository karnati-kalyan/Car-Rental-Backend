package com.fsd.Car_Rental_BackEnd.dto;

import com.fsd.Car_Rental_BackEnd.enums.CarType;
import lombok.Data;

@Data
public class CarDto {

    private Long id;

    public String carCompany;

    private String carName;

    private boolean availableToday;

    private Double pricePerHour;

    private String carType;
}
