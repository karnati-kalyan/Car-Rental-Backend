package com.fsd.Car_Rental_BackEnd.services.car;

import com.fsd.Car_Rental_BackEnd.dto.CarDto;
import com.fsd.Car_Rental_BackEnd.entity.Car;
import com.fsd.Car_Rental_BackEnd.enums.CarType;
import com.fsd.Car_Rental_BackEnd.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class carServiceImpl implements carService {

    private final CarRepository carRepository;


    @Override
    public List<Car> getCars() {
        return carRepository.findAllCars();
    }

    @Override
    public CarDto createCar(CarDto carDto){
        Car car = new Car();
        car.setCarCompany(carDto.getCarCompany());
        car.setCarName(carDto.getCarName());
        switch (carDto.getCarType()) {
            case "COMPACT":
                car.setCarType(CarType.COMPACT);
                System.out.print(carDto.getCarType());
                break;
            case "SUV":
                car.setCarType(CarType.SUV);
                break;
            case "XUV":
                car.setCarType(CarType.XUV);
                break;
            case "SEDAN":
                car.setCarType(CarType.SEDAN);
                System.out.print(carDto.getCarType());
                break;
            default:
                return null;
        }
        car.setPricePerHour(carDto.getPricePerHour());
        car.setAvailableToday(carDto.isAvailableToday());

        Car createdCar = carRepository.save(car);
        CarDto carDtoResponse = new CarDto();
        carDtoResponse.setCarCompany(createdCar.getCarCompany());
        carDtoResponse.setCarName(createdCar.getCarName());
        carDtoResponse.setCarType(String.valueOf(createdCar.getCarType()));
        carDtoResponse.setPricePerHour(createdCar.getPricePerHour());
        carDtoResponse.setAvailableToday(createdCar.isAvailableToday());

        return carDtoResponse;
    }
}
